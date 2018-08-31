package Service;

import Dao.PlayerDao;
import Domain.PageBean;
import Domain.Player;

public class PlayerService {

    PlayerDao playerDao = new PlayerDao();

    public void add(Player player){
        playerDao.add(player);
    }

    public void delete(String id){
        playerDao.delete(id);
    }

    public void edit(Player player){
        playerDao.edit(player);
    }

    public PageBean<Player> findAll(int pageCode,int pageRecord){
        return playerDao.findAll(pageCode,pageRecord);
    }

    public Player find(String id){
        return playerDao.find(id);
    }

    public PageBean<Player> query(Player player,int pageCode,int pageRecode){
        return playerDao.query(player,pageCode,pageRecode);
    }

}
