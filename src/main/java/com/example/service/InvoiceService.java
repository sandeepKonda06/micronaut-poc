package com.example.service;

import com.example.exception.AppException;
import com.example.model.InvoiceDTO;
import com.example.repository.InvoiceDao;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Singleton
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class InvoiceService {

    private final @NonNull InvoiceDao invoiceDao;

    public InvoiceDTO getInvoiceById(@NonNull String invoiceId) throws AppException {
        try {
            log.info("Executing InvoiceService.getInvoiceById for fetching Invoice : {}", invoiceId);
            return Optional.ofNullable(invoiceDao.getInvoiceById(invoiceId))
                    .orElseThrow(() -> {
                        String message = String.format("Invoice ID %s not found", invoiceId);
                        log.error(message);
                        return new AppException(message);
                    });
        } finally {
            log.info("Exiting InvoiceService.getInvoiceById after fetching Invoice");
        }
    }

    public InvoiceDTO createInvoice(InvoiceDTO invoiceDTO) throws AppException {
        try {
            log.info("Executing InvoiceService.createInvoice creating the invoice: {}", invoiceDTO);
            invoiceDao.createInvoice(invoiceDTO);
            return getInvoiceById(invoiceDTO.getId());
        } finally {
            log.info("Exiting InvoiceService.createInvoice after invoice creation");
        }
    }

    public List<InvoiceDTO> getAllInvoices() throws AppException {
        try {
            log.info("Executing InvoiceService.createInvoice fetching all the invoices");
            return invoiceDao.getAllInvoices();
        } finally {
            log.info("Exiting InvoiceService.createInvoice after fetching all the invoices");
        }
    }

    public InvoiceDTO updateInvoice(InvoiceDTO invoiceDTO) throws AppException {
        try {
            log.info("Executing InvoiceService.updateInvoice updating the invoice: {}", invoiceDTO);
            invoiceDao.updateInvoice(invoiceDTO);
            return getInvoiceById(invoiceDTO.getId());
        } finally {
            log.info("Exiting InvoiceService.updateInvoice updating the invoice");
        }
    }

    public void deleteInvoice(String invoiceId) throws AppException {
        try {
            log.info("Executing InvoiceService.deleteInvoice: {}", invoiceId);
            getInvoiceById(invoiceId);
            invoiceDao.deleteInvoice(invoiceId);
        } finally {
            log.info("Exiting InvoiceService.deleteInvoice after deleteInvoice");
        }
    }
}
