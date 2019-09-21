package com.lucida.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "menuDetail")
public class Menu {

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id ;

		@Column(name="menu_name")
		private String menu_name;
		
		@Column(name="mid")
		private int mid;
		
//		@Column(name="menu_url")
//		private int menu_url;

		public Menu(int id, String menu_name, int mid, int menu_url) {
			super();
			this.id = id;
			this.menu_name = menu_name;
			this.mid = mid;
//			this.menu_url = menu_url;
		}

		public Menu() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getMenu_name() {
			return menu_name;
		}

		public void setMenu_name(String menu_name) {
			this.menu_name = menu_name;
		}

		public int getMid() {
			return mid;
		}

		public void setMid(int mid) {
			this.mid = mid;
		}

//		public int getMenu_url() {
//			return menu_url;
//		}
//
//		public void setMenu_url(int menu_url) {
//			this.menu_url = menu_url;
//		}

		
	
}
