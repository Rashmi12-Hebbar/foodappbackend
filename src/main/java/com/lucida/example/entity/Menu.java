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

		public int getId() {
			return id;
		}

		public Menu(int id, String menu_name, int mid) {
			super();
			this.id = id;
			this.menu_name = menu_name;
			this.mid = mid;
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
	
}
