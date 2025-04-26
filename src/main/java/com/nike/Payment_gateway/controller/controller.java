package com.nike.Payment_gateway.controller;

import com.nike.Payment_gateway.entity.PaymentOrder;
import com.nike.Payment_gateway.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class controller {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create-order")
        public ResponseEntity<String> createOrder(@RequestBody PaymentOrder order){
            try{
                String serviceOrder=paymentService.createOrder(order);
                return ResponseEntity.ok(serviceOrder);

            } catch (Exception e) {
                return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error creating order");
            }
        }

    @PostMapping("/update-order")
    public ResponseEntity<String> updateOrder(@RequestParam String orderId,
                                              @RequestParam String paymentId,
                                              @RequestParam String status
                                              ){
        paymentService.updateOrderStatus(paymentId,orderId,status);
        System.out.println("Email Sent Succcesfull");
        return  ResponseEntity.ok("Order updated succesfully and email sent");

    }


}
