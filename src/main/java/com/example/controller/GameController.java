package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.repository.VehicleRepository;
import com.example.model.Tesla;
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

    @PostMapping("/addTesla")
    public String addTesla() {
        Tesla tesla = new Tesla(50, 300);
        vehicleRepository.save(tesla);
        return "redirect:/";
    }

    @PostMapping("/deleteVehicle")
    public String deleteVehicle(@RequestParam("vehicleId") Long id) {
        vehicleRepository.deleteById(id);
        return "redirect:/";
    }
}