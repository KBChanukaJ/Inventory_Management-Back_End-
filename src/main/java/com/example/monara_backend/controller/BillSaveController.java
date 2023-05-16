package com.example.monara_backend.controller;

import com.example.monara_backend.model.BillSave;
import com.example.monara_backend.model.PdfBillSave;
import com.example.monara_backend.service.BillSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/billdata")
public class BillSaveController {
    @Autowired
    private BillSaveService billSaveService;


    @PostMapping("/save")
    public ResponseEntity<BillSave> FormData(@RequestBody BillSave bill) {
       BillSave savedBill = billSaveService.FormData(bill);
        return ResponseEntity.ok(savedBill);
    }
    @GetMapping("/view")
    public List<BillSave> getAllDetails() {
        return billSaveService.getAllDetails();
    }


    @DeleteMapping("delete/{bill_id}")
    public ResponseEntity<String> deleteBill(@PathVariable Integer bill_id) {
        billSaveService.deleteBill(bill_id);
        return ResponseEntity.ok("Bill deleted");
    }
}