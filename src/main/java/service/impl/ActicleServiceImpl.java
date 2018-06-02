package service.impl;

import entity.*;
import mapper.ActicleMapper;
import mapper.ShareMapper;
import mapper.StarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ActicleService;
import service.CommentService;
import service.ImgService;
import service.LyUserService;
import util.HTMLSpirit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyu
 * @since 2018/2/4 20:07
 */
@Service
public class ActicleServiceImpl implements ActicleService{

    @Autowired
    ActicleMapper acticleMapperl;
    @Autowired
    LyUserService lyUserService;
    @Autowired
    ImgService imgService;
    @Autowired
    CommentService commentService;
    @Autowired
    StarMapper starMapper;

    @Autowired
    ShareMapper shareMapper;
    /**
     * 新增文章
     *
     * @param acticle
     */
    @Override
    public void add(Acticle acticle) {
        acticleMapperl.add(acticle);
    }

    /**
     * 查询所有文章
     *
     * @return
     */
    @Override
    public List<Acticle> getAll() {
        List<Acticle> acticleList = acticleMapperl.getAll();
        //新建一个list保存用户的信息
        List<Acticle> acticleListView = new ArrayList<Acticle>();
        for (Acticle acticle:acticleList){
            BigInteger user_id = acticle.getUser_id();
            //根据用户id查询用户的基本信息
            LyUser user = lyUserService.findById(user_id);
            List<Img> imgList = imgService.findByActicle(acticle.getId());

            acticle.setImgList(imgList);
            acticle.setLyUser(user);
            acticleListView.add(acticle);
        }
        return acticleListView;
    }

    /**
     * 查询所有文章
     *
     * @return
     */
    @Override
    public List<Acticle> getMyAll(BigInteger id) {
        List<Acticle> acticleList = acticleMapperl.getMyAll(id);
        //新建一个list保存用户的信息
        List<Acticle> acticleListView = new ArrayList<Acticle>();
        for (Acticle acticle:acticleList){
            BigInteger user_id = acticle.getUser_id();
            //根据用户id查询用户的基本信息
            LyUser user = lyUserService.findById(user_id);
            List<Img> imgList = imgService.findByActicle(acticle.getId());

            acticle.setImgList(imgList);
            acticle.setLyUser(user);
            acticleListView.add(acticle);
        }
        return acticleListView;
    }

    /**
     * 修改文章
     *
     * @param acticle
     */
    @Override
    public void update(Acticle acticle) {
            acticleMapperl.update(acticle);
    }

    /**
     * 删除文章
     *
     * @param id
     */
    @Override
    public void delele(java.math.BigInteger id) {
            acticleMapperl.delele(id);
    }

    /**
     * 根据星星排行
     */
    @Override
    public List<Acticle> startnum() {
        List<Acticle> acticleList = acticleMapperl.startnum();
        //新建一个list保存用户的信息
        List<Acticle> acticleListView = new ArrayList<Acticle>();
        for (Acticle acticle:acticleList){
            BigInteger user_id = acticle.getUser_id();
            //根据用户id查询用户的基本信息
            LyUser user = lyUserService.findById(user_id);
            List<Img> imgList = imgService.findByActicle(acticle.getId());
            acticle.setImgList(imgList);
            acticle.setLyUser(user);
            //过滤html标签
              String conten =  HTMLSpirit.Html2Text(acticle.getConten());
              if(conten.length()>115){
                  String substring = conten.substring(0, 100);
                  acticle.setConten(substring+"......");
              }
              else {
                  acticle.setConten(conten);
              }
            acticleListView.add(acticle);
        }
        return acticleListView;
    }

    /**
     * 根据星星排行
     */
    @Override
    public Acticle startmax() {
        Acticle startamxActicle = acticleMapperl.startamx();
        List<Img> imgList = imgService.findByActicle(startamxActicle.getId());
        startamxActicle.setImgList(imgList);
        return startamxActicle;
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public Acticle findById(BigInteger id) {

        List<Img> imgList = imgService.findByActicle(id);
        Acticle acticle = acticleMapperl.findById(id);
        if (acticle!=null){
            LyUser user = lyUserService.findById(acticle.getUser_id());
            List<Comment> commentList = commentService.findByActicleId(acticle.getId());
            acticle.setCommentList(commentList);
            acticle.setImgList(imgList);
            List<Star> starList = starMapper.findByActicleId(acticle.getId());
            acticle.setStar(starList.size());
            acticle.setLyUser(user);
        }
        return acticle;
    }

    /**
     * 根据用户id查询所有的文章
     *
     * @param id
     * @return
     */
    @Override
    public List<Acticle> findByUserId(BigInteger id) {

        List<Acticle> acticles = acticleMapperl.findByUserId(id);
        List<Acticle> acticleList = new ArrayList<Acticle>();
        for (Acticle acticle :acticles){
            List<Img> service = imgService.findByActicle(acticle.getId());
            acticle.setImgList(service);
            acticleList.add(acticle);
        }
        return acticleList;
    }

    /**
     * 查询该用户转发的内容
     * @param id
     * @return
     */
    @Override
    public List<Acticle> findByUserIdForword(BigInteger id){

        Share share = new Share();
        share.setUser_id(id);
        List<Acticle> acticles = new ArrayList<Acticle>();
        List<Share> shareList = shareMapper.getAll(share);
        for (Share share1: shareList) {
            Acticle acticle = acticleMapperl.findById(share1.getActicle_id());
            acticles.add(acticle);
        }

        return acticles;
    }

    /**
     * 根据标题查询
     *
     * @param title
     * @return
     */
    @Override
    public List<Acticle> selectActicle(String title) {
        return acticleMapperl.selectActicle(title);
    }

    /**
     * 修改文章状态
     *
     * @param acticle
     */
    @Override
    public void updateState(Acticle acticle) {

        acticleMapperl.updateState(acticle);
    }

    /**
     * 查询用户的分享记录
     *
     * @param user_id
     * @param acticle_id
     * @return
     */
    @Override
    public List<Acticle> forwardList(BigInteger user_id, BigInteger acticle_id) {
        List<Acticle> acticles = new ArrayList<Acticle>();
        Share share = new Share();
        share.setUser_id(user_id);
        share.setActicle_id(acticle_id);
        List<Share> shares = shareMapper.getUserAll(share);
        for (Share share1: shares) {
            Acticle acticle = acticleMapperl.findById(share1.getActicle_id());
            acticles.add(acticle);
        }
        return acticles;
    }

    /**
     * 查询用户的分享记录
     *
     * @param user_id
     * @return
     */
    @Override
    public List<Acticle> forwardUserList(BigInteger user_id) {

        List<Acticle> acticles = new ArrayList<Acticle>();
        Share share = new Share();
        share.setUser_id(user_id);
        List<Share> shares = shareMapper.getAll(share);
        for (Share share1: shares) {
            Acticle acticle = acticleMapperl.findById(share1.getActicle_id());
            acticles.add(acticle);
        }
        return acticles;
    }

}
