package io.husayn.fetch.model;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by husaynhakeem on 8/5/17.
 */

/**
 * Not all the attributes in this class are used, in fact only a few are.
 * Ideally the attributes that aren't used should be ignored (using the ignore annotation)
 */
@Parcel
public class Item {
    /**
     * id : 4kQA1aQK8-Y
     * created_at : 2016-05-29T15:42:02-04:00
     * width : 2448
     * height : 1836
     * color : #060607
     * likes : 12
     * liked_by_user : false
     * user : {"id":"OevW4fja2No","username":"nicholaskampouris","name":"Nicholas Kampouris","profile_image":{"small":"https://images.unsplash.com/profile-1464495186405-68089dcd96c3?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=32&w=32&s=63f1d805cffccb834cf839c719d91702","medium":"https://images.unsplash.com/profile-1464495186405-68089dcd96c3?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=64&w=64&s=ef631d113179b3137f911a05fea56d23","large":"https://images.unsplash.com/profile-1464495186405-68089dcd96c3?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=128&w=128&s=622a88097cf6661f84cd8942d851d9a2"},"links":{"self":"https://api.unsplash.com/users/nicholaskampouris","html":"http://unsplash.com/@nicholaskampouris","photos":"https://api.unsplash.com/users/nicholaskampouris/photos","likes":"https://api.unsplash.com/users/nicholaskampouris/likes"}}
     * urls : {"raw":"https://images.unsplash.com/photo-1464550883968-cec281c19761","full":"https://images.unsplash.com/photo-1464550883968-cec281c19761?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&s=4b142941bfd18159e2e4d166abcd0705","regular":"https://images.unsplash.com/photo-1464550883968-cec281c19761?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&w=1080&fit=max&s=1881cd689e10e5dca28839e68678f432","small":"https://images.unsplash.com/photo-1464550883968-cec281c19761?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&w=400&fit=max&s=d5682032c546a3520465f2965cde1cec","thumb":"https://images.unsplash.com/photo-1464550883968-cec281c19761?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&w=200&fit=max&s=9fba74be19d78b1aa2495c0200b9fbce"}
     * categories : [{"id":4,"title":"Nature","photo_count":46148,"links":{"self":"https://api.unsplash.com/categories/4","photos":"https://api.unsplash.com/categories/4/photos"}},{"id":6,"title":"People","photo_count":15513,"links":{"self":"https://api.unsplash.com/categories/6","photos":"https://api.unsplash.com/categories/6/photos"}}]
     * links : {"self":"https://api.unsplash.com/photos/4kQA1aQK8-Y","html":"http://unsplash.com/photos/4kQA1aQK8-Y","download":"http://unsplash.com/photos/4kQA1aQK8-Y/download"}
     */

    public String id;
    public String created_at;
    public int width;
    public int height;
    public String color;
    public int likes;
    public boolean liked_by_user;
    public User user;
    public Urls urls;
    public Links links;
    public List<Category> categories;


    @Parcel
    public static class User {
        /**
         * id : OevW4fja2No
         * username : nicholaskampouris
         * name : Nicholas Kampouris
         * profile_image : {"small":"https://images.unsplash.com/profile-1464495186405-68089dcd96c3?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=32&w=32&s=63f1d805cffccb834cf839c719d91702","medium":"https://images.unsplash.com/profile-1464495186405-68089dcd96c3?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=64&w=64&s=ef631d113179b3137f911a05fea56d23","large":"https://images.unsplash.com/profile-1464495186405-68089dcd96c3?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=128&w=128&s=622a88097cf6661f84cd8942d851d9a2"}
         * links : {"self":"https://api.unsplash.com/users/nicholaskampouris","html":"http://unsplash.com/@nicholaskampouris","photos":"https://api.unsplash.com/users/nicholaskampouris/photos","likes":"https://api.unsplash.com/users/nicholaskampouris/likes"}
         */

        public String id;
        public String username;
        public String name;
        public ProfileImageBean profile_image;
        public LinksBean links;


        @Parcel
        public static class ProfileImageBean {
            /**
             * small : https://images.unsplash.com/profile-1464495186405-68089dcd96c3?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=32&w=32&s=63f1d805cffccb834cf839c719d91702
             * medium : https://images.unsplash.com/profile-1464495186405-68089dcd96c3?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=64&w=64&s=ef631d113179b3137f911a05fea56d23
             * large : https://images.unsplash.com/profile-1464495186405-68089dcd96c3?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=128&w=128&s=622a88097cf6661f84cd8942d851d9a2
             */

            public String small;
            public String medium;
            public String large;
        }

        @Parcel
        public static class LinksBean {
            /**
             * self : https://api.unsplash.com/users/nicholaskampouris
             * html : http://unsplash.com/@nicholaskampouris
             * photos : https://api.unsplash.com/users/nicholaskampouris/photos
             * likes : https://api.unsplash.com/users/nicholaskampouris/likes
             */

            public String self;
            public String html;
            public String photos;
            public String likes;
        }
    }


    @Parcel
    public static class Urls {
        /**
         * raw : https://images.unsplash.com/photo-1464550883968-cec281c19761
         * full : https://images.unsplash.com/photo-1464550883968-cec281c19761?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&s=4b142941bfd18159e2e4d166abcd0705
         * regular : https://images.unsplash.com/photo-1464550883968-cec281c19761?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&w=1080&fit=max&s=1881cd689e10e5dca28839e68678f432
         * small : https://images.unsplash.com/photo-1464550883968-cec281c19761?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&w=400&fit=max&s=d5682032c546a3520465f2965cde1cec
         * thumb : https://images.unsplash.com/photo-1464550883968-cec281c19761?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&w=200&fit=max&s=9fba74be19d78b1aa2495c0200b9fbce
         */

        public String raw;
        public String full;
        public String regular;
        public String small;
        public String thumb;
    }


    @Parcel
    public static class Links {
        /**
         * self : https://api.unsplash.com/photos/4kQA1aQK8-Y
         * html : http://unsplash.com/photos/4kQA1aQK8-Y
         * download : http://unsplash.com/photos/4kQA1aQK8-Y/download
         */

        public String self;
        public String html;
        public String download;
    }


    @Parcel
    public static class Category {
        /**
         * id : 4
         * title : Nature
         * photo_count : 46148
         * links : {"self":"https://api.unsplash.com/categories/4","photos":"https://api.unsplash.com/categories/4/photos"}
         */

        public int id;
        public String title;
        public int photo_count;
        public LinksBeanXX links;


        @Parcel
        public static class LinksBeanXX {
            /**
             * self : https://api.unsplash.com/categories/4
             * photos : https://api.unsplash.com/categories/4/photos
             */

            public String self;
            public String photos;
        }
    }
}
