package com.zls.db;

import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;

public class DBUtil extends ConnDB{
	


	/**
	 * Insert
	 * 
	 * @param tableName
	 *          
	 * @param documents
	 *       
	 * @return
	 */
	public static boolean insert(String tableName, List<Document> documents) {
		boolean isSuccess = true;
		try {
			getCollection(tableName).insertMany(documents);
		} catch (Exception e) {
			isSuccess = false;
			e.printStackTrace();
		} finally {

		}

		return isSuccess;
	}

	/**
	 * Delete
	 * 
	 * @param tableName
	 *            
	 * @param doc
	 *            �ĵ�
	 * @return
	 */
	public static boolean delete(String tableName, Document doc) {
		boolean isSuccess = true;
		try {
			getCollection(tableName).deleteOne(doc);
		} catch (Exception e) {
			isSuccess = false;
			e.printStackTrace();
		} finally {

		}

		return isSuccess;
	}

	/**
	 * ��ѯ
	 * 
	 * @param tableName
	 *            �������
	 * @param doc
	 *            �ĵ�
	 * @return
	 */
	public static FindIterable<Document> find(String tableName, Document doc) {
		FindIterable<Document> results = null;
		try {
			if (doc != null) {

				results = getCollection(tableName).find(doc);
			} else {
				results = getCollection(tableName).find();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close();
		}

		return results;
	}

	/**
	 * update
	 * 
	 * @param tableName
	 * @param doc
	 * @return
	 */
	public static boolean update(String tableName, Document oldDoc, Document newDoc) {
		boolean flag = true;
		try {

			Document update = new Document();
			update.append("$set", newDoc);
			getCollection(tableName).updateOne(oldDoc, update);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		} 

		return flag;
	}
	
	
	public static void main(String[] args) {
	}
}
