CREATE TABLE Project (
    project_id int(11) NOT NULL AUTO_INCREMENT,
    project varchar(100)  NOT NULL,
    start_date datetime  NULL,
    end_date datetime  NULL,
    priority int  NOT NULL,
    PRIMARY KEY (project_id)
)ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;


CREATE TABLE task (
		  task_id int(11) NOT NULL AUTO_INCREMENT,
		  task varchar(50) DEFAULT NULL,
		  start_date date DEFAULT NULL,
		  end_date date DEFAULT NULL,
		  priority int(11) DEFAULT NULL,
		  parent_id int(11) DEFAULT NULL,
          project_id int(11) DEFAULT NULL,
		  IsActive varchar(255) DEFAULT NULL,
		  PRIMARY KEY (task_id),
		  KEY parent_task_ind (parent_id),
		  CONSTRAINT task_ibfk_1 FOREIGN KEY (parent_id) REFERENCES parent_task (parent_id) ON DELETE CASCADE,
		  KEY project_ind (project_id),
		  CONSTRAINT project_ibfk_1 FOREIGN KEY (project_id) REFERENCES project (project_id) ON DELETE CASCADE
		) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
        
CREATE TABLE parent_task (
  parent_id int(11) NOT NULL AUTO_INCREMENT,
  parent_task varchar(500) NOT NULL,
  PRIMARY KEY (parent_id)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;



CREATE TABLE user (
		  user_id int(11) NOT NULL AUTO_INCREMENT,
		  first_name varchar(50) NOT NULL,
          last_name varchar(50) NOT NULL,
          employee_id varchar(50) NOT NULL,
		  project_id int(11) DEFAULT NULL,
		  task_id int(11) DEFAULT NULL,
		  PRIMARY KEY (user_id),
		  KEY user_task_ind (task_id),
		  CONSTRAINT user_task_ibfk_1 FOREIGN KEY (task_id) REFERENCES task (task_id) ON DELETE CASCADE,
		  KEY use_project_ind (project_id),
		  CONSTRAINT user_project_ibfk_1 FOREIGN KEY (project_id) REFERENCES project (project_id) ON DELETE CASCADE
		) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;






