package com.pm.consta;

public class Constant {
	public static String CREATE_TABLE_USER = "create table if not exists users(_id integer primary key auto_increment,user_id text,username text,firstname text,lastname text,email text,password text,role varchar(40),date_entered text,status integer,contact_phone text,sex text, addr_line1 text,addr_line2 text,wechat text,qq_no text,no_of_retry varchar(40),device_sn text,face_id text,card_id text,photo_url text,updated_date text,created_by integer,updated_by integer)";
	public static String CREATE_TABLE_DEVICE = "create table if not exists devices(_id integer primary key auto_increment,device_id text,device_name text,sn text, owner_usrname text, owner_card_id text,owner_userTable_name text,license_code text)";

}
