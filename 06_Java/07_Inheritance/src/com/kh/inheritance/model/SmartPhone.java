package com.kh.inheritance.model;

import com.kh.inheritance.model.parent.Product;

public class SmartPhone extends Product {

		private String agency;
		
		public SmartPhone() {
			
		}
		
		public String getAgency() {
			return agency;
		}

		public void setAgency(String agency) {
			this.agency = agency;
		}
		
		@Override
		public String toString() {
			return "SmartPhone [agency=" + agency + "]";
		}
}
