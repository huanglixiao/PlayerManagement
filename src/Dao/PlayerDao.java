package Dao;

import Domain.PageBean;
import Domain.Player;
import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.ArrayList;
import java.util.List;

public class PlayerDao {
    private QueryRunner queryRunner = new TxQueryRunner();

    public void add(Player player){
        try {
            String sql = "insert into t_player values(?,?,?,?,?,?)";
            Object[] params = {player.getId(),player.getName(),player.getTeam(),player.getPosition(),
                    player.getAge(),player.getDescription()};
            queryRunner.update(sql,params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public PageBean<Player> findAll(int pageCode,int pageRecord){
        try {
            PageBean<Player> pageBean = new PageBean<>();
            pageBean.setPageCode(pageCode);
            pageBean.setPageRecords(pageRecord);
            String sql = "select count(*) from t_player";
            Number number = (Number) queryRunner.query(sql,new ScalarHandler<>());
            int totalRecord = number.intValue();
            pageBean.setTotalRecords(totalRecord);
            sql = "select * from t_player order by name limit ?,?";
            Object[] params = {(pageCode - 1) * pageRecord,pageRecord};
            List<Player> beanList = queryRunner.query(sql,new BeanListHandler<>(Player.class),params);
            pageBean.setBeanList(beanList);
            return pageBean;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Player find(String id){
        try {
            String sql = "select * from t_player where id = ?";
            return queryRunner.query(sql,new BeanHandler<>(Player.class),id);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public void edit(Player player){
        try {
            String sql = "update t_player set name = ?,team = ?,position = ?,age = ?,description = ? where id =?";
            Object[] params = {player.getName(),player.getTeam(),player.getPosition(),player.getAge(),player.getDescription(),
            player.getId()};
            queryRunner.update(sql,params);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public void delete(String id){
        try {
            String sql = "delete from t_player where id = ?";
            queryRunner.update(sql,id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public PageBean<Player> query(Player player,int pageRecord,int pageCode){
        try {
            PageBean<Player> pageBean = new PageBean<>();
            pageBean.setPageCode(pageCode);
            pageBean.setPageRecords(pageRecord);
            StringBuilder cntSql = new StringBuilder("select count(*) from t_player ");
            StringBuilder whereSql=new StringBuilder(" where 1=1 ");
            List<Object> params = new ArrayList<>();

            String name = player.getName();
            if (name != null && !name.trim().isEmpty()){
                whereSql.append("and name like ?");
                params.add("%"+name+"%");
            }

            String team = player.getTeam();
            if (team != null && !team.trim().isEmpty()){
                whereSql.append("and team like ?");
                params.add("%"+team+"%");
            }

            String position = player.getPosition();
            if (position != null && !position.trim().isEmpty()){
                whereSql.append("and position like ?");
                params.add("%" + position + "%");
            }

            String age = player.getAge();
            if (age != null && !age.trim().isEmpty()){
                whereSql.append("and age like ?");
                params.add("%" + age + "%");
            }

            Number number = queryRunner.query(cntSql.append(whereSql).toString(),new ScalarHandler<>(),params.toArray());
            int totalRecord = number.intValue();
            pageBean.setTotalRecords(totalRecord);
            StringBuilder sql = new StringBuilder("select * from t_player");
            StringBuilder limitSql = new StringBuilder("limit ?,?");
            params.add((pageCode - 1) * pageRecord);
            params.add(pageRecord);
            List<Player> beanList = queryRunner.query(sql.append(whereSql).append(limitSql).toString(),
                   new BeanListHandler<Player>(Player.class),params.toArray());
            pageBean.setBeanList(beanList);
            return pageBean;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
