CREATE TABLE `User_info` (
	  `userid` INTEGER PRIMARY KEY AUTO_INCREMENT,
	  `firstname` VARCHAR(255) NOT NULL,
	  `lastname` VARCHAR(255) NOT NULL,
	  `role` VARCHAR(255) NOT NULL
	);

	CREATE TABLE `User_login` (
		  `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
		  `username` VARCHAR(100) UNIQUE NOT NULL,
		  `passwordhash` VARCHAR(255) NOT NULL,
		  `passwordsalt` VARCHAR(255) NOT NULL,
		  `userinfo` VARCHAR(255) NOT NULL
		);

		CREATE TABLE `priviledge` (
			  `id` INTEGER PRIMARY KEY AUTO_INCREMENT
			);

			CREATE TABLE `role` (
				  `roleid` INTEGER PRIMARY KEY AUTO_INCREMENT,
				  `name` VARCHAR(255) NOT NULL
				);

				CREATE TABLE `role_priviledge` (
					  `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
					  `role` VARCHAR(255) NOT NULL,
					  `priviledge` VARCHAR(255) NOT NULL
					)
