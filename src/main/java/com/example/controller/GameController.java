package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.repository.VehicleRepository;
import com.example.model.Tesla;
import com.example.model.Audi;
import com.example.model.F1;
import com.example.model.Vehicle;

@Controller
public class GameController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("vehicles", vehicleRepository.findAll());
        return "home";
    }

    @PostMapping("/addVehicle")
    public String addVehicle(@RequestParam("carType") String carType) {
        int vehicleCount = (int) vehicleRepository.count();
        int startX = 20 + (vehicleCount * 40);
        int startY = 180;

        Vehicle vehicle;
        switch (carType.toLowerCase()) {
            case "tesla":
                vehicle = new Tesla(startX, startY);
                break;
            case "audi":
                vehicle = new Audi(startX, startY);
                break;
            case "f1":
                vehicle = new F1(startX, startY);
                break;
            default:
                throw new IllegalArgumentException("Unknown car type: " + carType);
        }

        vehicleRepository.save(vehicle);
        return "redirect:/";
    }

    @PostMapping("/deleteVehicle")
    public String deleteVehicle(@RequestParam("vehicleId") Long id) {
        vehicleRepository.deleteById(id);
        return "redirect:/";
    }
}