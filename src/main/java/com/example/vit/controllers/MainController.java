package com.example.vit.controllers;


import com.example.vit.dto.*;
import com.example.vit.entity.*;
import com.example.vit.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController

@RequiredArgsConstructor
public class MainController {

    private final TypeOfOwnerShipRepository typeOfOwnerShipRepository;
    private final ModelsRepository modelsRepository;
    private final CarBrandRepository carBrandRepository;
    private final BankRepository bankRepository;
    private final BuyerRepository buyerRepository;
    private final ProviderRepository providerRepository;
    private final PaymentOrderRepository paymentOrderRepository;
    private final AgreementRepository agreementRepository;
    private final ConfidantRepository confidantRepository;
    private final PtsRepository ptsRepository;
    private final TransmissionPointRepository transmissionPointRepository;
    private final ActRepository actRepository;
    private final CarRepository carRepository;

    private final CheckRepository checkRepository;
    private final TypeAutoPartRepository typeAutoPartsRepository;

    private final LocationRepository locationRepository;


    @GetMapping("/getTypesOfOwnerShip")
    public List<TypeOfOwnerShip> getAllTypes() {
        return typeOfOwnerShipRepository.findAll();
    }

    @GetMapping("/getAllModels")
    public List<Models> getAllModels() {
        return modelsRepository.findAll();
    }

    @GetMapping("/getModels/{brand}")
    public List<Models> getAllModelsByBrand(@PathVariable String brand) {
        var carBrand = carBrandRepository.getCarBrandsByBrand(brand);

        return modelsRepository.findAllByCarBrand(carBrand);

    }

    @GetMapping("/getAllCarBrands")
    public List<CarBrand> getAllCarBrand() {
        return carBrandRepository.findAll();
    }


    @GetMapping("/getAllLocation")
    public List<Location> getAllLocation() {
        return locationRepository.findAll();
    }

    @PostMapping("/createBuyer")
    public String createBuyer(@RequestBody BuyerDto buyerDto) {

        if (buyerRepository.existsBuyerByName(buyerDto.name)) {
            return "EXIST";
        }
        var typeOfOwnerShip = typeOfOwnerShipRepository.getTypeOfOwnerShipByTypeOfOwnerShip(buyerDto.typeOfOwner);
        var bank = bankRepository.getBankByName(buyerDto.bank);
        var location = locationRepository.getLocationsByLocation(buyerDto.location);
        var buyer = new Buyer();
        buyer.inn = buyerDto.inn;
        buyer.name = buyerDto.name;

        buyer.typeOfOwnerShip = typeOfOwnerShip;
        buyer.bank = bank;

        buyer.kpp = buyerDto.kpp;
        buyer.kscore = buyerDto.kscore;
        buyer.rscore = buyerDto.rscore;

        buyer.location = location;
        buyerRepository.save(buyer);

        return "" + buyer.id;

    }


    @GetMapping("/getProvider/{id}")
    public Provider[] getProvider(@PathVariable("id") Long id) {
        return new Provider[]{providerRepository.getProvidersById(id)};
    }


    @GetMapping("/getBuyer/{id}")
    public Buyer[] getBuyer(@PathVariable("id") Long id) {
        return new Buyer[]{buyerRepository.getBuyerById(id)};
    }

    @PostMapping("/createProvider")
    public String createProvider(@RequestBody ProviderDto providerDto) {
        if (providerRepository.existsProviderByName(providerDto.name)) {
            return "EXIST";
        }
        var typeOfOwnerShip = typeOfOwnerShipRepository.getTypeOfOwnerShipByTypeOfOwnerShip(providerDto.typeOfOwner);
        var bank = bankRepository.getBankByName(providerDto.bank);
        var location = locationRepository.getLocationsByLocation(providerDto.location);

        var provider = new Provider();
        provider.inn = providerDto.inn;
        provider.name = providerDto.name;

        provider.typeOfOwnerShip = typeOfOwnerShip;
        provider.bank = bank;


        provider.kpp = providerDto.kpp;
        provider.kscore = providerDto.kscore;
        provider.rscore = providerDto.rscore;
        provider.location = location;
        providerRepository.save(provider);
        return provider.id + "";
    }

    @GetMapping("/getAllProviders")
    public List<Provider> getListProvider() {
        return providerRepository.findAll();
    }

    @GetMapping("/getAllBuyers")
    public List<Buyer> getListBuyers() {
        return buyerRepository.findAll();
    }

    @GetMapping("/getAllBanks")
    public List<Bank> getListBanks() {
        return bankRepository.findAll();
    }


    @PostMapping("/createAgreement")
    public String createAgreement(@RequestBody AgreementDto agreementDto) {

        var agreement = new Agreement();
        agreement.buyer = buyerRepository.getBuyerByName(agreementDto.buyerName);
        agreement.provider = providerRepository.getProvidersByName(agreementDto.providerName);

        agreement.date = agreementDto.date;
        agreement.paymentOrder = paymentOrderRepository.getPaymentOrderByNumber(agreementDto.numberPayment);
        agreement.number = agreementDto.number;

        if (agreementRepository.existsAgreementByNumber(agreement.number)) {
            return "EXIST";
        }
        agreementRepository.save(agreement);
        return "" + agreement.id;
    }

    @PostMapping("/createConfidant")
    public String createConfidant(@RequestBody ConfidantDto confidantDto) {
        var confidant = new Confidant();
        confidant.surname = confidantDto.surname;

        confidant.name = confidantDto.name;

        confidant.patronymic = confidantDto.patronymic;

        confidant.numberConfidant = confidantDto.numberConfidant;

        confidant.confidant = confidantDto.confidant;

        confidant.seriaPassport = confidantDto.seriaPassport;

        confidant.numberPassport = confidantDto.numberPassport;

        confidant.dataOutput = confidantDto.dataOutput;

        confidant.whoOutput = confidantDto.whoOutput;
        try {
            confidantRepository.save(confidant);
        } catch (Exception e) {
            e.printStackTrace();
            return "EXIST";
        }
        return "" + confidant.id;
    }


    @GetMapping("/getAllConfidant")
    public List<Confidant> findAllConfidant() {
        return confidantRepository.findAll();
    }

    @PostMapping("/createPts")
    public String createPTS(@RequestBody Pts pts) {
        try {
            ptsRepository.save(pts);
            return pts.id + "";
        } catch (Exception e) {
            return "Exist";
        }
    }

    @PostMapping("/createAct")
    public String createAct(@RequestBody ActDto actDto) {

        var act = new Act();
        act.dateTransmission = actDto.dateTransmission;
        act.transmissionPoint = transmissionPointRepository.getTransmissionPointByTransmissionPoint(actDto.transmissionPoint);
        act.agreement = agreementRepository.getAgreementById(actDto.agreement);
        act.confidant = confidantRepository.getConfidantByNumberConfidant(actDto.confidant);
        act.number = actDto.number;
        try {
            actRepository.save(act);
            return act.id + "";
        } catch (Exception e) {
            return "EXIST";
        }
    }


    @GetMapping("/getAllTransmission")
    public List<TransmissionPoint> getAllTransmissionPoint() {
        return transmissionPointRepository.findAll();
    }


    @GetMapping("/getConf/{id}")
    public Confidant[] getConf(@PathVariable Long id) {
        return new Confidant[]{confidantRepository.getConfidantById(id)};
    }

    @PostMapping("/createPaymentOrder")
    public String createPaymentOrder(@RequestBody PaymentOrderDto paymentOrderDto) {
        var payment = new PaymentOrder();
        payment.date = paymentOrderDto.date;
        payment.number = paymentOrderDto.number;
        payment.sum = paymentOrderDto.sum;
        var agreement = agreementRepository.getAgreementByNumber(paymentOrderDto.number);

        var provider = agreement.provider;
        var buyer = agreement.buyer;

        payment.buyer_inn = buyer.inn;
        payment.buyer_kpp = buyer.kpp;
        payment.buyer_kscore = buyer.kscore;
        payment.buyer_location = buyer.location;
        payment.buyer_rscore = buyer.rscore;


        payment.provider_inn = provider.inn;
        payment.provider_kpp = provider.kpp;
        payment.provider_kscore = provider.kscore;
        payment.provider_location = provider.location;
        payment.provider_rscore = provider.rscore;

        paymentOrderRepository.save(payment);

        agreement.paymentOrder = payment;
        agreementRepository.save(agreement);
        return payment.id + "";
    }

    @RequestMapping(value = "/createCar", method = RequestMethod.POST)
    public String createCar(@RequestBody CarDto carDto) {


        // Получение существующих объектов из базы данных

        //Models models = modelsRepository.getModelsByModel(carDto.models);

        Pts pts = ptsRepository.findById(carDto.ptsId).orElseThrow();

        Act act = actRepository.getActById(carDto.actNumber);


        // Создание нового автомобиля с полученными данными

        Car car = new Car();

        car.setModel(carDto.models);

        car.setNumberEngine(carDto.numberEngine);


        car.setPts(pts);

        car.setPrice(carDto.price);

        car.setAct(act);


        // Сохранение нового автомобиля в базе данных

        carRepository.save(car);


        // Возврат идентификатора созданного автомобиля

        return car.id + "";

    }


    @RequestMapping(value = "/createCheck", method = RequestMethod.POST)

    public String createCheck(@RequestBody CheckDto checkDto) {


        // Создание нового чека

        Check check = new Check();


        // Установка атрибутов чека из данных объекта checkDto

        check.setNumber(checkDto.number);

        check.setDate(checkDto.date);

        check.setAllPrice(checkDto.allPrice);

        check.setActAutoParts(actRepository.getActByNumber(checkDto.actNumber));


        // Создание списка объектов AutoPart из объектов AutoPartDto

        List<AutoPart> autoParts = checkDto.autoPartDtos.stream().map(autoPartDto -> {

            AutoPart autoPart = new AutoPart();

            autoPart.setTypeAutoParts(typeAutoPartsRepository.getTypeAutoPartsByTypeAutoParts(autoPartDto.typeAutoParts));

            autoPart.setCarBrands(carBrandRepository.getCarBrandsByBrand(autoPartDto.carBrands));

            autoPart.setModels(modelsRepository.findAllByModels(autoPartDto.models));

            autoPart.setPrice(autoPartDto.price);

            autoPart.setCount(autoPartDto.count);

            autoPart.setResultSum(autoPartDto.resultSum);

            return autoPart;

        }).collect(Collectors.toList());


        // Установка списка объектов AutoPart для чека

        check.setAutoParts(autoParts);


        // Сохранение нового чека в базе данных

        checkRepository.save(check);


        // Возврат идентификатора созданного чека

        return check.getId() + "";

    }

    @GetMapping("/diagram1")
    public List<DataDto> getInformationForDiagram() {
        List<Object[]> results = carRepository.getDiagram1();

        List<DataDto> dataDtos = new ArrayList<>();

        for (Object[] result : results) {
            String confidantName = (String) result[0];
            Long carCount = (Long) result[1];
            var dataDto = new DataDto();
            dataDto.name = confidantName;
            dataDto.count = carCount;

            dataDtos.add(dataDto);

        }

        return dataDtos;
    }


    @GetMapping("/view")
    public List<ReportDto> report() {
        // var list = carRepository.findCarsWithConfidants();
        List<ReportDto> reportDtos = new ArrayList<>();
/*
        for (int i = 0; i < list.size(); i++) {
            var report = new ReportDto();
            report.car = (Car) list.get(i)[0];
            report.confidant = (Confidant) list.get(i)[1];
            report.act = (Act) list.get(i)[2];

            reportDtos.add(report);
        }


 */

        List<Confidant> confidant = confidantRepository.findAll();

        for (int i = 0; i < confidant.size(); i++) {
            var report = new ReportDto();
            report.confidant = confidant.get(i);

            reportDtos.add(report);
        }

        return reportDtos;
    }


}