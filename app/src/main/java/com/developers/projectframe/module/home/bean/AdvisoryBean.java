package com.developers.projectframe.module.home.bean;

/**
 * @Author yinzh
 * @Date 2020/3/22 09:51
 * @Description
 */
public class AdvisoryBean {
    public AdvisoryBean consultations;


    private InfoBean articleDetail; //资讯 详情页
    private InfoBean openCourseDetail; //公开课 详情页
    private InfoBean freeCourseDetail; //免费课 详情页

    public InfoBean getArticleDetail() {
        return articleDetail;
    }

    public void setArticleDetail(InfoBean articleDetail) {
        this.articleDetail = articleDetail;
    }

    public InfoBean getOpenCourseDetail() {
        return openCourseDetail;
    }

    public void setOpenCourseDetail(InfoBean openCourseDetail) {
        this.openCourseDetail = openCourseDetail;
    }

    public InfoBean getFreeCourseDetail() {
        return freeCourseDetail;
    }

    public void setFreeCourseDetail(InfoBean freeCourseDetail) {
        this.freeCourseDetail = freeCourseDetail;
    }

    public class InfoBean {
        private String consultImg;
        private String consultText;

        public String getConsultImg() {
            return consultImg;
        }

        public void setConsultImg(String consultImg) {
            this.consultImg = consultImg;
        }

        public String getConsultText() {
            return consultText;
        }

        public void setConsultText(String consultText) {
            this.consultText = consultText;
        }
    }
}
