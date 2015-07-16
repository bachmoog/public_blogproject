-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 16, 2015 at 09:37 AM
-- Server version: 5.5.43-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `capstone2`
--

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE IF NOT EXISTS `authorities` (
  `username` varchar(20) NOT NULL,
  `authority` varchar(20) NOT NULL,
  KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('test', 'ROLE_ADMIN'),
('test', 'ROLE_USER'),
('test2', 'ROLE_USER'),
('test', 'ROLE_ADMIN'),
('test', 'ROLE_USER'),
('test2', 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `blogs`
--

CREATE TABLE IF NOT EXISTS `blogs` (
  `blog_id` int(11) NOT NULL AUTO_INCREMENT,
  `blog_title` varchar(100) NOT NULL,
  `blog_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `blog_content` mediumtext NOT NULL,
  `user_id` int(11) NOT NULL,
  `published` tinyint(1) NOT NULL,
  `approved` tinyint(1) NOT NULL,
  PRIMARY KEY (`blog_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `blogs`
--

INSERT INTO `blogs` (`blog_id`, `blog_title`, `blog_date`, `blog_content`, `user_id`, `published`, `approved`) VALUES
(1, 'Fire', '2015-06-19 04:00:00', 'Bacon ipsum dolor amet ham hock t-bone leberkas picanha ball tip porchetta andouille sausage pig brisket pastrami shankle kielbasa meatball turkey. Meatball pastrami frankfurter alcatra, brisket pig pork chop t-bone porchetta kielbasa. Biltong tenderloin chicken ham hock kielbasa pork belly sirloin jowl corned beef tri-tip swine hamburger ground round shoulder salami. Shankle corned beef pork chop shank pork belly.', 2, 0, 0),
(2, 'Ice', '2015-06-18 04:00:00', 'Tongue tenderloin venison beef ribs cupim. Meatball bacon corned beef filet mignon venison, picanha strip steak jerky t-bone. Jowl tail doner spare ribs beef ribs alcatra. Pork loin ball tip shankle meatloaf, turducken venison hamburger strip steak pastrami short ribs brisket jowl.', 1, 0, 1),
(3, 'Water', '2015-06-20 04:00:00', 'Flank sirloin chicken venison frankfurter tenderloin. Brisket shoulder fatback, salami strip steak pig ball tip. Meatball pancetta sausage kevin prosciutto fatback. Cow short loin venison porchetta swine pork beef ribs pork loin tri-tip rump strip steak landjaeger turkey. Turducken pork flank tail. Porchetta short ribs strip steak shank chuck, meatball drumstick filet mignon tenderloin salami alcatra hamburger boudin. Shoulder hamburger beef ribs drumstick ham.', 1, 1, 1),
(4, 'Earth', '2015-06-17 04:00:00', 'Fatback landjaeger porchetta, salami bacon biltong boudin venison. Beef ribs pork chop tenderloin kevin short ribs short loin porchetta chicken tri-tip andouille chuck. Tongue biltong pancetta fatback, tri-tip pastrami capicola. Cupim biltong sirloin andouille. Drumstick cow t-bone, sirloin short ribs kevin pastrami meatloaf.', 1, 0, 1),
(5, 'Wind', '2015-06-21 04:00:00', 'Ipsem lorem gypsum fiah, is the best rhyme you wished to wish?', 1, 1, 0),
(11, 'Mud', '2015-06-26 16:54:10', 'Somewhere between Water and Earth', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `blog_category_bridge`
--

CREATE TABLE IF NOT EXISTS `blog_category_bridge` (
  `blog_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  KEY `blog_id` (`blog_id`,`category_id`),
  KEY `category_id` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `blog_category_bridge`
--

INSERT INTO `blog_category_bridge` (`blog_id`, `category_id`) VALUES
(1, 1),
(1, 2),
(1, 4),
(2, 1),
(2, 3),
(3, 3),
(4, 1),
(11, 2);

-- --------------------------------------------------------

--
-- Table structure for table `blog_hashtag_bridge`
--

CREATE TABLE IF NOT EXISTS `blog_hashtag_bridge` (
  `blog_id` int(11) NOT NULL,
  `hashtag_id` int(11) NOT NULL,
  KEY `blog_id` (`blog_id`,`hashtag_id`),
  KEY `hashtag_id` (`hashtag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `blog_hashtag_bridge`
--

INSERT INTO `blog_hashtag_bridge` (`blog_id`, `hashtag_id`) VALUES
(1, 1),
(1, 3),
(1, 4),
(1, 6),
(2, 3),
(2, 4),
(2, 5),
(2, 5),
(5, 5),
(5, 8),
(5, 9),
(11, 8);

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(50) NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `category` (`category`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`category_id`, `category`) VALUES
(1, 'Bacon'),
(5, 'Hard to Believe'),
(6, 'Mud'),
(4, 'Salads'),
(2, 'Too Much Bacon'),
(3, 'What''s the Fuss?');

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE IF NOT EXISTS `comments` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` mediumtext NOT NULL,
  `user_id` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `blog_id` int(11) NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `user_id` (`user_id`,`blog_id`),
  KEY `blog_id` (`blog_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`comment_id`, `comment`, `user_id`, `date`, `blog_id`) VALUES
(1, 'To go places and do things that have never been done before – that’s what living is all about.', 1, '2015-06-20 04:00:00', 2),
(2, 'Science has not yet mastered prophecy. We predict too much for the next year and yet far too little for the next 10.', 2, '2015-06-20 04:00:00', 1),
(3, 'Buy why, some say, the moon? Why choose this as our goal? And they may as well ask why climb the highest mountain?', 2, '2015-06-20 04:00:00', 3),
(12, 'We choose to go to the moon in this decade and do the other things, not because they are easy, but because they are hard, because that goal will serve to organize and measure the best of our energies and skills, because that challenge is one that we are willing to accept, one we are unwilling to postpone, and one which we intend to win.\r\n', 1, '2015-06-20 04:00:00', 1),
(13, 'That''s one small step for [a] man, one giant leap for mankind.', 2, '2015-06-20 04:00:00', 1),
(14, 'Houston, Tranquillity Base here. The Eagle has landed.', 1, '2015-06-20 04:00:00', 1),
(15, 'A Chinese tale tells of some men sent to harm a young girl who, upon seeing her beauty, become her protectors rather than her violators. That''s how I felt seeing the Earth for the first time. I could not help but love and cherish her.', 2, '2015-06-20 04:00:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `hashtags`
--

CREATE TABLE IF NOT EXISTS `hashtags` (
  `hashtag_id` int(11) NOT NULL AUTO_INCREMENT,
  `hashtag` varchar(50) NOT NULL,
  PRIMARY KEY (`hashtag_id`),
  UNIQUE KEY `hashtag` (`hashtag`),
  KEY `hashtag_2` (`hashtag`),
  KEY `hashtag_id` (`hashtag_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `hashtags`
--

INSERT INTO `hashtags` (`hashtag_id`, `hashtag`) VALUES
(5, '#Bacon - good for the soul'),
(1, '#bacony'),
(8, '#BadRhyme'),
(10, '#foo'),
(6, '#I''m a vegitarian'),
(9, '#IDontLikeFishes'),
(12, '#Mud'),
(4, '#Oink'),
(3, '#Thems good Hamhocks'),
(2, '#Yummy');

-- --------------------------------------------------------

--
-- Table structure for table `static_pages`
--

CREATE TABLE IF NOT EXISTS `static_pages` (
  `static_page_id` int(11) NOT NULL AUTO_INCREMENT,
  `page_content` mediumtext NOT NULL,
  `user_id` int(11) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `page_title` varchar(125) NOT NULL,
  PRIMARY KEY (`static_page_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `static_pages`
--

INSERT INTO `static_pages` (`static_page_id`, `page_content`, `user_id`, `date_created`, `page_title`) VALUES
(1, '<p>Tongue tenderloin venison beef ribs cupim. Meatball bacon corned beef filet mignon venison, picanha strip steak jerky t-bone. Jowl tail doner spare ribs beef ribs alcatra. Pork loin ball tip shankle meatloaf, turducken venison hamburger strip steak pastrami short ribs brisket jowl.</p>', 1, '2015-07-16 13:35:15', 'Bacon Rules');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `enabled`) VALUES
(1, 'test', 'password', 1),
(2, 'test2', 'password', 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Constraints for table `blogs`
--
ALTER TABLE `blogs`
  ADD CONSTRAINT `blogs_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION;

--
-- Constraints for table `blog_category_bridge`
--
ALTER TABLE `blog_category_bridge`
  ADD CONSTRAINT `blog_category_bridge_ibfk_3` FOREIGN KEY (`blog_id`) REFERENCES `blogs` (`blog_id`) ON DELETE NO ACTION,
  ADD CONSTRAINT `blog_category_bridge_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`) ON DELETE NO ACTION;

--
-- Constraints for table `blog_hashtag_bridge`
--
ALTER TABLE `blog_hashtag_bridge`
  ADD CONSTRAINT `blog_hashtag_bridge_ibfk_2` FOREIGN KEY (`hashtag_id`) REFERENCES `hashtags` (`hashtag_id`) ON DELETE NO ACTION,
  ADD CONSTRAINT `blog_hashtag_bridge_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `blogs` (`blog_id`) ON DELETE NO ACTION;

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`blog_id`) REFERENCES `blogs` (`blog_id`) ON DELETE NO ACTION,
  ADD CONSTRAINT `comments_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION;

--
-- Constraints for table `static_pages`
--
ALTER TABLE `static_pages`
  ADD CONSTRAINT `static_pages_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
