package com.developers.projectframe.module.home.bean;

public class MessageBean {

    /**
     * code : 0
     * message : success
     * data : {"consultations":{"openCourseDetail":{"consultImg":"https://scd4a2b5c5k9-sb-qn.qiqiuyun.net/files/system/2019/07-15/150425944692261946.png?7.5.14.45","consultText":""},"freeCourseDetail":{"consultImg":"https://scd4a2b5c5k9-sb-qn.qiqiuyun.net/files/system/2019/07-15/150430ebc957193361.png?7.5.14.45","consultText":""},"articleDetail":{"consultImg":"https://scd4a2b5c5k9-sb-qn.qiqiuyun.net/files/system/2019/07-15/1504353c5545746306.png?7.5.14.45","consultText":""}}}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * consultations : {"openCourseDetail":{"consultImg":"https://scd4a2b5c5k9-sb-qn.qiqiuyun.net/files/system/2019/07-15/150425944692261946.png?7.5.14.45","consultText":""},"freeCourseDetail":{"consultImg":"https://scd4a2b5c5k9-sb-qn.qiqiuyun.net/files/system/2019/07-15/150430ebc957193361.png?7.5.14.45","consultText":""},"articleDetail":{"consultImg":"https://scd4a2b5c5k9-sb-qn.qiqiuyun.net/files/system/2019/07-15/1504353c5545746306.png?7.5.14.45","consultText":""}}
         */

        private ConsultationsBean consultations;

        public ConsultationsBean getConsultations() {
            return consultations;
        }

        public void setConsultations(ConsultationsBean consultations) {
            this.consultations = consultations;
        }

        public static class ConsultationsBean {
            /**
             * openCourseDetail : {"consultImg":"https://scd4a2b5c5k9-sb-qn.qiqiuyun.net/files/system/2019/07-15/150425944692261946.png?7.5.14.45","consultText":""}
             * freeCourseDetail : {"consultImg":"https://scd4a2b5c5k9-sb-qn.qiqiuyun.net/files/system/2019/07-15/150430ebc957193361.png?7.5.14.45","consultText":""}
             * articleDetail : {"consultImg":"https://scd4a2b5c5k9-sb-qn.qiqiuyun.net/files/system/2019/07-15/1504353c5545746306.png?7.5.14.45","consultText":""}
             */

            private OpenCourseDetailBean openCourseDetail;
            private FreeCourseDetailBean freeCourseDetail;
            private ArticleDetailBean articleDetail;

            public OpenCourseDetailBean getOpenCourseDetail() {
                return openCourseDetail;
            }

            public void setOpenCourseDetail(OpenCourseDetailBean openCourseDetail) {
                this.openCourseDetail = openCourseDetail;
            }

            public FreeCourseDetailBean getFreeCourseDetail() {
                return freeCourseDetail;
            }

            public void setFreeCourseDetail(FreeCourseDetailBean freeCourseDetail) {
                this.freeCourseDetail = freeCourseDetail;
            }

            public ArticleDetailBean getArticleDetail() {
                return articleDetail;
            }

            public void setArticleDetail(ArticleDetailBean articleDetail) {
                this.articleDetail = articleDetail;
            }

            public static class OpenCourseDetailBean {
                /**
                 * consultImg : https://scd4a2b5c5k9-sb-qn.qiqiuyun.net/files/system/2019/07-15/150425944692261946.png?7.5.14.45
                 * consultText :
                 */

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

            public static class FreeCourseDetailBean {
                /**
                 * consultImg : https://scd4a2b5c5k9-sb-qn.qiqiuyun.net/files/system/2019/07-15/150430ebc957193361.png?7.5.14.45
                 * consultText :
                 */

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

            public static class ArticleDetailBean {
                /**
                 * consultImg : https://scd4a2b5c5k9-sb-qn.qiqiuyun.net/files/system/2019/07-15/1504353c5545746306.png?7.5.14.45
                 * consultText :
                 */

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
    }
}
