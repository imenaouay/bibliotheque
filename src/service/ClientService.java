package service;

import bean.Client;
import dao.ConnectDB;
import dao.ClientDao;


import inter.ClientInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.List;
import util.DaoEngigne;

public class ClientService extends UnicastRemoteObject implements ClientInterface {
   ClientDao  userDao = new ClientDao();

    public ClientService() throws RemoteException {
        super();
    }

    public int seConnecter(Client user) throws RemoteException {
        return userDao.seConnecter(user);
    }
   @Override
    public int save(Client t) throws Exception, RemoteException {
        return userDao.save(t);
    }
     public List<Client> findAll() throws Exception, RemoteException{
          return userDao.findAll();
     }
     
     public int Inscription(Client client) throws RemoteException {
         return userDao.Inscription(client);
     }
     public Client findById(String id) throws Exception,RemoteException {
         return userDao.findById(id);
     }

     public byte[]  getImage(String id) throws Exception,RemoteException {
       
        ResultSet rs = userDao.findAll_rs(id);
        if(rs.next()){
         byte[] img = rs.getBytes("image");
         return img;
       }
         return null;
    }
}