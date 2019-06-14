drop table if exists `note`;

CREATE TABLE `note` (
  `id` varchar(255) NOT NULL,
  `author_id` varchar(255) DEFAULT NULL,
  `date_record_added` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

