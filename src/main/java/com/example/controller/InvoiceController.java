package com.example.controller;

import com.example.exception.AppException;
import com.example.model.InvoiceDTO;
import com.example.service.InvoiceService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.server.netty.encoders.HttpResponseEncoder;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import java.util.List;

@Controller("/invoice")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Inject))
@Validated
public class InvoiceController {

    private final @NonNull InvoiceService invoiceService;

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public HttpResponse<InvoiceDTO> createInvoice(@Body @Valid InvoiceDTO invoiceDTO) throws AppException {
        try {
            log.info("Executing InvoiceController.createInvoice creating the invoice: {}", invoiceDTO);
            return HttpResponse.created(invoiceService.createInvoice(invoiceDTO));
        } finally {
            log.info("Exiting InvoiceController.createInvoice after invoice creation");
        }
    }

    @Put
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public HttpResponse<InvoiceDTO> updateInvoice(@Body InvoiceDTO invoiceDTO) throws AppException {
        try {
            log.info("Executing InvoiceController.updateInvoice updateInvoice all invoices");
            return HttpResponse.ok(invoiceService.updateInvoice(invoiceDTO));
        } finally {
            log.info("Exiting InvoiceController.updateInvoice after updateInvoice");
        }
    }

    @Delete
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public HttpResponse<String> deleteInvoice(@NonNull @QueryValue(value = "invoiceId") String invoiceId ) throws AppException {
        try {
            log.info("Executing InvoiceController.deleteInvoice deleteInvoice");
            invoiceService.deleteInvoice(invoiceId);
            return HttpResponse.ok("Successfully Deleted invoiceId : " + invoiceId);
        } finally {
            log.info("Exiting InvoiceController.deleteInvoice after deleteInvoice");
        }
    }

    @Get("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public HttpResponse<List<InvoiceDTO>> getAllInvoices() throws AppException {
        try {
            log.info("Executing InvoiceController.getAllInvoices fetching all invoices");
            return HttpResponse.ok(invoiceService.getAllInvoices());
        } finally {
            log.info("Exiting InvoiceController.getAllInvoices after fetching all invoices");
        }
    }

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public InvoiceDTO getInvoiceById(@QueryValue(value = "invoiceId") String invoiceId) throws AppException {
        try {
            log.info("Executing InvoiceController.getInvoiceById for fetching invoice id : {}", invoiceId);
            return invoiceService.getInvoiceById(invoiceId);
        } finally {
            log.info("Exiting InvoiceController.getInvoiceById after fetching invoice");
        }
    }
}
