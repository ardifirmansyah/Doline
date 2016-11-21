/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author USER-PC
 */
public class Data_user {
    private ArrayList list_user=new ArrayList<User>();
    private ArrayList data_transaksi=new ArrayList<TransactionRecord>();

    public ArrayList getList_user() {
        return list_user;
    }

    public ArrayList getData_transaksi() {
        return data_transaksi;
    }
    
    
}

   
