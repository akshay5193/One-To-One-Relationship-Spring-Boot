package com.akshay.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akshay.relationships.models.License;
import com.akshay.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	
	private final LicenseRepository licenseRepository;

	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> getAllLicenses() {
		return licenseRepository.findAll();
	}
	
	public License createLicense(String licenseNumber, License license) {
		license.setNumber(licenseNumber);
		System.out.println("License Number: " + license.getNumber());
		System.out.println("Person: " + license.getPerson().getFirstName());
		return licenseRepository.save(license);
	}

}
