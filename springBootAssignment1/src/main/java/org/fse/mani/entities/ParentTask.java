package org.fse.mani.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "parent_task")
public class ParentTask {

    private int parent_id;
    private String parent_task;
    private Set<Task> tasks;
    
    public ParentTask() {
    }

    public ParentTask(int parent_id) {
        this.parent_id = parent_id;
    }
    
    public ParentTask(int parent_id, String parent_task,  Set<Task> tasks) {
        this.parent_id = parent_id;
        this.parent_task = parent_task;
        this.tasks= tasks;
    }

    @Id
    @Column(name = "parent_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
   

    @Column(name = "parent_task")
    public String getParent_task() {
		return parent_task;
	}

	public void setParent_task(String parent_task) {
		this.parent_task = parent_task;
	}

    @OneToMany(mappedBy = "parentTask",fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.MERGE)
    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
        this.tasks.retainAll(tasks);
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentTask parentTask = (ParentTask) o;
        return parent_id == parentTask.parent_id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(parent_id);
    }

    @Override
    public String toString() {
        return "ParentTask{" +
                "Parent Task Id =" + parent_id +
                ", parent_task='" + parent_task + '\'' +
                '}';
    }
	

	
}
