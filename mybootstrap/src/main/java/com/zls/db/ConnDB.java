package com.zls.db;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ConnDB {

	private static final String DATABASENAME = "mybootstrap";
	private static MongoClient mongoClient;
	private static String host = "127.0.0.1";// the host name
	private static int port = 27017;//

	/**
	 * get the collection in
	 * 
	 * 
	 * @param databaseName
	 *            ��ݿ����
	 * @param collectionName
	 *            �������
	 * @return MongoCollection<Document>
	 */
	public static MongoCollection<Document> getCollection(String collectionName) {
		MongoCollection<Document> collection = null;
		try {
			collection = getDB().getCollection(collectionName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return collection;
	}

	/**
	 * get the db 
	 * 
	 * @return
	 */
	public static MongoDatabase getDB() {
		MongoDatabase db = null;
		try {
			mongoClient = new MongoClient(host, port);
			db = mongoClient.getDatabase(DATABASENAME);
		} catch (Exception e) {
			System.out.println("get the db failed");
			e.printStackTrace();
		}
		return db;
	}



	/**
	 * close the mongo client
	 */
	public static void close() {
		try {
			if (mongoClient != null) {
				mongoClient.close();
			}
		} catch (Exception e) {
			
		}
	}

}
