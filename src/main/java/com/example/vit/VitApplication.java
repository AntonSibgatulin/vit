package com.example.vit;

import com.example.vit.entity.*;
import com.example.vit.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class VitApplication {

    public static void main(String[] args) {
        SpringApplication.run(VitApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("POST", "GET", "OPTIONS", "DELETE");
            }
        };
    }

    //@Bean
    public CommandLineRunner commandLineRunner(CarRepository carRepository,
                                               ActRepository actRepository,
                                               AgreementRepository agreementRepository,
                                               ProviderRepository providerRepository,
                                               BuyerRepository buyerRepository,
                                               ConfidantRepository confidantRepository,
                                               TransmissionPointRepository transmissionPointRepository,
                                               PtsRepository ptsRepository,
                                               CarBrandRepository carBrandRepository,
                                               ModelsRepository modelsRepository) {
        return args -> {


            for (int i = 0; i < 1000; i++) {
                var provider = providerRepository.getProvidersById(Long.valueOf(1 + new Random().nextInt(3)));
                var buyer = buyerRepository.getBuyerById(Long.valueOf(1 + new Random().nextInt(3)));
                var agreement = new Agreement();
                agreement.buyer = buyer;
                agreement.provider = provider;
                agreement.number = new Random().nextInt(9999999);
                agreement.date = new Date(System.currentTimeMillis());
                agreementRepository.save(agreement);


                var confidant = confidantRepository.getConfidantById(Long.valueOf(1 + new Random().nextInt(3)));

                var trans = new String[]{
                        "Главной офис",
                        "Офис покупателя",
                        "Парковка",
                        "Склад",
                        "Стоянка"

                };
                var transmissionPoint = transmissionPointRepository.getTransmissionPointByTransmissionPoint(trans[new Random().nextInt(trans.length)]);

                var act = new Act();
                act.number = new Random().nextInt(9999999);
                act.confidant = confidant;
                act.dateTransmission = new Date(System.currentTimeMillis());
                act.transmissionPoint = transmissionPoint;
                act.agreement = agreement;

                actRepository.save(act);

                var carBrand = carBrandRepository.getCarBrandsByBrand("ВАЗ");


                var colors = new String[]{
                        "Чёрный",
                        "Синий",
                        "Белый"
                };

                var pts = new Pts();
                pts.axisNumber = "Нет";
                pts.brand = carBrand;
                pts.color = colors[new Random().nextInt(colors.length)];
                pts.engineNumber = "" + new Random().nextInt(237847238);
                pts.number = "" + new Random().nextInt(237847238);
                pts.registrationAuthority = "ГУ МВД ПО МОСКВЕ И МОСКОВСКОЙ ОБЛАСТИ";

                pts.enginePower = 90 + new Random().nextInt(30);
                pts.manufacturer = "АВТОВАЗ";
                pts.registrationDate = new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24 * (10 + new Random().nextInt(100)));
                pts.vin = "" + System.currentTimeMillis();
                pts.year = 2016 + new Random().nextInt(8);

                var models = new String[]{
                        "X-ray",
                        "Веста",
                        "Гранта",
                        "Приора",
                        "2114"
                };
                pts.model = modelsRepository.getModelsByModel(models[new Random().nextInt(models.length)]);

                ptsRepository.save(pts);

                var car = new Car();
                car.act = act;
                car.pts = pts;
                car.numberEngine = pts.engineNumber;
                car.model = carBrand.brand + " " + pts.model.model;
                car.price = 900000 + new Random().nextInt(2000000);

                carRepository.save(car);
            }
        };
    }
}
