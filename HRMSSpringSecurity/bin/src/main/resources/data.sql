INSERT IGNORE INTO `role` (`roleid`, `rolename`) VALUES
	(3, 'ROLE_MENTOR'),
	(2, 'ROLE_HR'),
	(1, 'ROLE_ADMIN');


INSERT IGNORE INTO `user` (`userid`, `username`, `useremail`, `userpassword`) VALUES
	(1,'Admin', 'admin@aroha.co.in', '$2a$10$7sFPuv1oAYlgVQSzzCdQwe5fo28SYUJZ7jsIdJJXtMfccghn7sknq');

INSERT IGNORE INTO `user_roles` (`user_id`, `role_id`) VALUES
	(1, 1);