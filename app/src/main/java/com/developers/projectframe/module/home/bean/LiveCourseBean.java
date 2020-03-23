package com.developers.projectframe.module.home.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.developers.projectframe.network.bean.BaseEntity;
import com.developers.projectframe.network.bean.BasePageEntity;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * @Author yinzh
 * @Date 2020/3/23 16:23
 * @Description
 */
public class LiveCourseBean extends BasePageEntity implements MultiItemEntity {

    @SerializedName(value = "lessons", alternate = "openCourses")
    public ArrayList<LiveCourseBean> openCourses;

    public int type; // 适配器的type

    private int id; //课时
    private int courseId; //课程id
    private String mediaId; //直播id
    private String length; //直播时长
    private String title;
    private String nickname;
    private long startTime; //开始时间
    private long endTime; //结束时间
    private String summary; //课程介绍
    private String learnedNum; //已学习人数
    private String reserveNum; //预约人数
    private String smallPicture; //小图


    private String smallAvatar;
    private String middlePicture; //中图
    private String mediumAvatar;
    private String largePicture; //大图
    private String largeAvatar;
    private String liveStatus; //appointment:预约,liveStatus:直播中,replay:回放
    private boolean isReserve; //是否已预约
    private String sharePicture; //分享成小程序封面

    private String liveUrl; //直播地址

    private MainLecturerBean mainLecturer; //主讲教师


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getLearnedNum() {
        return learnedNum;
    }

    public void setLearnedNum(String learnedNum) {
        this.learnedNum = learnedNum;
    }

    public String getReserveNum() {
        return reserveNum;
    }

    public void setReserveNum(String reserveNum) {
        this.reserveNum = reserveNum;
    }

    public String getSmallPicture() {
        return smallPicture;
    }

    public void setSmallPicture(String smallPicture) {
        this.smallPicture = smallPicture;
    }

    public String getMiddlePicture() {
        return middlePicture;
    }

    public void setMiddlePicture(String middlePicture) {
        this.middlePicture = middlePicture;
    }

    public String getLargePicture() {
        return largePicture;
    }

    public void setLargePicture(String largePicture) {
        this.largePicture = largePicture;
    }

    public String getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(String liveStatus) {
        this.liveStatus = liveStatus;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean isReserve() {
        return isReserve;
    }

    public void setReserve(boolean reserve) {
        isReserve = reserve;
    }

    public String getSharePicture() {
        return sharePicture;
    }

    public void setSharePicture(String sharePicture) {
        this.sharePicture = sharePicture;
    }

    public String getLiveUrl() {
        return liveUrl;
    }

    public void setLiveUrl(String liveUrl) {
        this.liveUrl = liveUrl;
    }

    public MainLecturerBean getMainLecturer() {
        return mainLecturer;
    }

    public void setMainLecturer(MainLecturerBean mainLecturer) {
        this.mainLecturer = mainLecturer;
    }

    public String getNickName() {
        return nickname;
    }

    public void setNickName(String nickName) {
        this.nickname = nickName;
    }

    public String getSmallAvatar() {
        return smallAvatar;
    }

    public void setSmallAvatar(String smallAvatar) {
        this.smallAvatar = smallAvatar;
    }

    public String getMiddleAvatar() {
        return mediumAvatar;
    }

    public void setMiddleAvatar(String middleAvatar) {
        this.mediumAvatar = middleAvatar;
    }

    public String getLargeAvatar() {
        return largeAvatar;
    }

    public void setLargeAvatar(String largeAvatar) {
        this.largeAvatar = largeAvatar;
    }

    @Override
    public int getItemType() {
        return type;
    }


    public class MainLecturerBean {
        private String nickname;
        private String largeAvatar;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getLargeAvatar() {
            return largeAvatar;
        }

        public void setLargeAvatar(String largeAvatar) {
            this.largeAvatar = largeAvatar;
        }
    }
}

