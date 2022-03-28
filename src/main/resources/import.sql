INSERT INTO roles(id, name) VALUES(1, 'ROLE_USER');
INSERT INTO roles(id, name) VALUES(2, 'ROLE_MODERATOR');
INSERT INTO roles(id, name) VALUES(3, 'ROLE_ADMIN');

INSERT INTO categories(id, name) VALUES(1, 'Books');
INSERT INTO categories(id, name) VALUES(2, 'Games');
INSERT INTO categories(id, name) VALUES(3, 'Movies');
INSERT INTO categories(id, name) VALUES(4, 'Anime');
INSERT INTO categories(id, name) VALUES(5, 'TV series');

INSERT INTO tags(id, name) VALUES(1, 'Horror');
INSERT INTO tags(id, name) VALUES(2, 'Action');
INSERT INTO tags(id, name) VALUES(3, 'Wow');
INSERT INTO tags(id, name) VALUES(4, 'Awesome');
INSERT INTO tags(id, name) VALUES(5, 'Amazing');
INSERT INTO tags(id, name) VALUES(6, 'Awful');
INSERT INTO tags(id, name) VALUES(7, 'WTF');
INSERT INTO tags(id, name) VALUES(8, 'LoL');
INSERT INTO tags(id, name) VALUES(9, 'LMAO');
INSERT INTO tags(id, name) VALUES(10, 'IT');
INSERT INTO tags(id, name) VALUES(11, 'YOLO');
INSERT INTO tags(id, name) VALUES(12, 'Detective');
INSERT INTO tags(id, name) VALUES(13, 'Novel');
INSERT INTO tags(id, name) VALUES(14, 'Sci-fi');
INSERT INTO tags(id, name) VALUES(15, 'Strategy');
INSERT INTO tags(id, name) VALUES(16, 'Fantasy');


insert into users(id, email, image_url, password, rating, unblocked, username) values (1,'user1@mail.ru', null, '$2a$10$DXR.7FM938z0OsIB3BlunuseLDBhn7wqt5chyH4xEwjM/JebCOf1.', 3, true, 'user1');
insert into users(id, email, image_url, password, rating, unblocked, username) values (2,'user2@mail.ru', null, '$2a$10$DXR.7FM938z0OsIB3BlunuseLDBhn7wqt5chyH4xEwjM/JebCOf1.', 2, true, 'user2');
insert into users(id, email, image_url, password, rating, unblocked, username) values (3,'user3@mail.ru', null, '$2a$10$DXR.7FM938z0OsIB3BlunuseLDBhn7wqt5chyH4xEwjM/JebCOf1.', 2, true, 'user3');

insert into user_roles VALUES (1,3);
insert into user_roles VALUES (1,1);
insert into user_roles VALUES (2,1);
insert into user_roles VALUES (3,1);

insert into reviews (id, author_score, full_text, like_count, release_date, title, user_score, category_id, user_id) values (1, 100, ' Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed congue aliquet porttitor. Vestibulum in enim lectus. Etiam eros sapien, sollicitudin eu euismod a, consequat euismod est. Cras id mollis dolor. Fusce fringilla tempor feugiat. Nulla et orci eget purus suscipit posuere at quis ante. Nam vitae ullamcorper ex. Integer pellentesque euismod sagittis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Maecenas tempor sapien et mattis tempor. Cras hendrerit accumsan pulvinar. Suspendisse bibendum dignissim mauris quis dapibus. Proin rhoncus ultricies odio, vitae tempor magna. Sed pulvinar, nulla sed euismod mollis, dolor nibh vestibulum odio, sed mollis nisl odio id justo. Vivamus aliquet vel tortor nec vehicula. Phasellus at felis eget tortor euismod convallis sed sit amet odio. Sed fringilla urna ac congue fringilla. Nunc orci lacus, vehicula euismod ipsum feugiat, finibus gravida mauris. Pellentesque pellentesque odio at libero interdum sagittis. \n\n Proin nec efficitur turpis. Ut eget fringilla felis, eu vulputate nisi. Sed sollicitudin eget magna nec hendrerit. Ut convallis sed felis eu porttitor. Fusce quis egestas urna. Mauris sed nisi ullamcorper, facilisis ligula malesuada, vehicula sapien. Sed nulla velit, eleifend id erat at, tempus eleifend dui. Integer euismod lectus quis purus finibus, non feugiat felis luctus. \n\n Phasellus condimentum et tellus at aliquam. Nunc bibendum lorem mauris, eu congue leo sodales nec. ', 3, ADDDATE(CURRENT_TIME, INTERVAL -1 HOUR), 'First review', 90 , 1, 1);
insert into reviews (id, author_score, full_text, like_count, release_date, title, user_score, category_id, user_id) values (2, 80, ' Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed congue aliquet porttitor. Vestibulum in enim lectus. Etiam eros sapien, sollicitudin eu euismod a, consequat euismod est. Cras id mollis dolor. Fusce fringilla tempor feugiat. Nulla et orci eget purus suscipit posuere at quis ante. Nam vitae ullamcorper ex. Integer pellentesque euismod sagittis. Interdum et malesuada fames ac ante ipsum primis in faucibus. \n\nMaecenas tempor sapien et mattis tempor. Cras hendrerit accumsan pulvinar. Suspendisse bibendum dignissim mauris quis dapibus. Proin rhoncus ultricies odio, vitae tempor magna. Aliquam vel purus ut ex dapibus iaculis. In non tristique ligula. Cras non malesuada felis. Quisque dignissim, mauris vel pulvinar hendrerit, magna nisl ultricies libero, ac elementum metus ex id leo. Aenean maximus sodales tortor, in cursus nisi ultricies ut. Nunc imperdiet purus vel nunc molestie, eu sagittis sapien pharetra. Aliquam erat volutpat. Nam ut accumsan orci, at suscipit ante. Proin placerat leo mauris. Pellentesque convallis eleifend tortor, non bibendum diam pretium id. Curabitur non lorem neque.\n\n Sed a elementum nulla. Maecenas et mi eu leo rutrum aliquam. Curabitur varius odio a turpis euismod varius. Maecenas vel ligula condimentum, venenatis libero id, dictum velit. Nunc vestibulum congue ipsum quis feugiat. Vestibulum aliquam tellus velit, quis interdum dui porttitor sed. Curabitur ultricies, justo eget consectetur porttitor, neque tortor tincidunt turpis, eu aliquam risus leo id nisl. Nunc leo mi, malesuada sed scelerisque a, sagittis eget est.\n\n Morbi non iaculis nisi, eget viverra diam. Curabitur suscipit, urna sed volutpat tincidunt, urna enim sagittis erat, ac interdum nunc diam nec ipsum. Duis ullamcorper aliquam dui quis venenatis. Vivamus fermentum porttitor diam eget lacinia. Aenean eget mi in massa tristique euismod id eu tortor. Vestibulum convallis eros sed nibh pretium sodales. Duis sed enim ultricies lorem ullamcorper pulvinar in sed ipsum. Vestibulum a bibendum justo. Suspendisse potenti. ', 1, ADDDATE(CURRENT_TIME, INTERVAL -20 MINUTE), 'Second review', 80 , 2, 2);
insert into reviews (id, author_score, full_text, like_count, release_date, title, user_score, category_id, user_id) values (3, 60, ' Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed congue aliquet porttitor. Vestibulum in enim lectus. Etiam eros sapien, sollicitudin eu euismod a, consequat euismod est. Cras id mollis dolor. Fusce fringilla tempor feugiat. Nulla et orci eget purus suscipit posuere at quis ante. Nam vitae ullamcorper ex. Integer pellentesque euismod sagittis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Maecenas tempor sapien et mattis tempor. Cras hendrerit accumsan pulvinar. Suspendisse bibendum dignissim mauris quis dapibus.\n\n Proin rhoncus ultricies odio, vitae tempor magna. ', 2, ADDDATE(CURRENT_TIME, INTERVAL -1 MINUTE), 'Third review', 40 , 3, 3);

insert into review_tags (review_id, tag_id) values (1,1);
insert into review_tags (review_id, tag_id) values (1,2);
insert into review_tags (review_id, tag_id) values (1,6);
insert into review_tags (review_id, tag_id) values (1,3);
insert into review_tags (review_id, tag_id) values (1,5);
insert into review_tags (review_id, tag_id) values (1,7);
insert into review_tags (review_id, tag_id) values (1,4);
insert into review_tags (review_id, tag_id) values (2,1);
insert into review_tags (review_id, tag_id) values (2,2);
insert into review_tags (review_id, tag_id) values (2,3);
insert into review_tags (review_id, tag_id) values (2,4);
insert into review_tags (review_id, tag_id) values (2,5);
insert into review_tags (review_id, tag_id) values (2,6);
insert into review_tags (review_id, tag_id) values (2,7);
insert into review_tags (review_id, tag_id) values (3,6);
insert into review_tags (review_id, tag_id) values (3,7);
insert into review_tags (review_id, tag_id) values (3,8);
insert into review_tags (review_id, tag_id) values (3,12);

insert into likes (id, review_id, user_id) values (1, 1, 1);
insert into likes (id, review_id, user_id) values (2, 1, 2);
insert into likes (id, review_id, user_id) values (3, 1, 3);
insert into likes (id, review_id, user_id) values (4, 2, 3);
insert into likes (id, review_id, user_id) values (5, 3, 1);
insert into likes (id, review_id, user_id) values (6, 3, 2);

insert into scores (id, score, review_id, user_id) values (1, 100, 1, 1);
insert into scores (id, score, review_id, user_id) values (2, 80, 1, 2);
insert into scores (id, score, review_id, user_id) values (3, 60, 2, 3);
insert into scores (id, score, review_id, user_id) values (4, 100, 2, 1);
insert into scores (id, score, review_id, user_id) values (5, 40, 3, 2);

insert into comments (id, comment_text, release_date, review_id, user_id) values (1,'Wow! Amazing! I like it. Nice review, mate.', ADDDATE(CURRENT_TIME, INTERVAL -20 MINUTE),1,1);
insert into comments (id, comment_text, release_date, review_id, user_id) values (2,'Etiam in mauris odio. Curabitur venenatis nec sapien vel tincidunt. Donec eget luctus velit, sed tincidunt augue.', ADDDATE(CURRENT_TIME, INTERVAL -25 MINUTE),1,3);
insert into comments (id, comment_text, release_date, review_id, user_id) values (3,'Sed nec magna et eros pretium sagittis tincidunt a lectus.', ADDDATE(CURRENT_TIME, INTERVAL -30 MINUTE),1,2);
insert into comments (id, comment_text, release_date, review_id, user_id) values (4,'Curabitur accumsan leo rutrum enim dictum, in imperdiet lectus gravida. Maecenas condimentum maximus nulla sit amet pretium.', ADDDATE(CURRENT_TIME, INTERVAL -15 MINUTE),2,1);
insert into comments (id, comment_text, release_date, review_id, user_id) values (5,'Proin tristique, arcu id bibendum varius, libero ante aliquam ante, sit amet iaculis neque libero ut justo. ', ADDDATE(CURRENT_TIME, INTERVAL -10 MINUTE),2,1);

