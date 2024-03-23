import entity.Priority;
import entity.Status;
import entity.Task;
import entity.TaskData;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Task taskDummy = new Task("s15d2","dummy desc bob","bob", Priority.HIGH, Status.ASSIGNED);
        Task taskForBob2 = new Task("s15d2","dummy desc 2 bob ","bob",Priority.HIGH,Status.IN_PROGRESS);
        Set<Task> bobsTasks = new HashSet<>();
        bobsTasks.add(taskDummy);
        bobsTasks.add(taskForBob2);

        Task taskForAnn = new Task("s15d2","dummy desc ann ","ann",Priority.MEDIUM,Status.IN_QUEUE);
        Task taskForAnn2 = new Task("s15d2","dummy desc 2 ann ","ann",Priority.LOW,Status.ASSIGNED);
        Set<Task> annsTasks = new HashSet<>();
        annsTasks.add(taskForAnn);
        annsTasks.add(taskForAnn2);

        Task taskForCarol = new Task("s15d2","dummy desc carol ","carol",Priority.HIGH,Status.IN_PROGRESS);
        Task taskForCarol2 = new Task("s15d2","dummy desc 2 carol ","carol",Priority.MEDIUM,Status.ASSIGNED);
        Set<Task> carolsTasks = new HashSet<>();
        carolsTasks.add(taskForCarol);
        carolsTasks.add(taskForCarol2);

        Task taskForUnassigned = new Task("s15d2","dummy desc unassigned ",null,Priority.HIGH,Status.IN_PROGRESS);
        Task taskForUnassigned2 = new Task("s15d2","dummy desc 2 unassigned ",null,Priority.MEDIUM,Status.ASSIGNED);
        Set<Task> unAssignedTasks = new HashSet<>();
        unAssignedTasks.add(taskForUnassigned);
        unAssignedTasks.add(taskForUnassigned2);


        Set<Task> allTasks = new HashSet<>();
        allTasks.add(taskForBob2);
        allTasks.add(taskDummy);
        allTasks.add(taskForAnn);
        allTasks.add(taskForAnn2);
        allTasks.add(taskForCarol);
        allTasks.add(taskForCarol2);
        allTasks.add(taskForUnassigned);
        allTasks.add(taskForUnassigned2);



        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, unAssignedTasks);

        System.out.println("-----------------**1**--------------------");
        Set<Task> all = taskData.getTasks("all");
        System.out.println(all.toString());

        System.out.println("-----------------**2**--------------------");
        System.out.println(taskData.getTasks("bob"));
        System.out.println(taskData.getTasks("ann"));
        System.out.println(taskData.getTasks("carol"));

        System.out.println("-----------------**3**--------------------");
        System.out.println();
        System.out.println(taskData.getDifferences(allTasks, taskData.getTasks("all")));


        System.out.println("-----------------**4**--------------------");
        System.out.println("----------------- BOB - ANN --------------------");
        Set<Task> intersectionBobAnn = taskData.getIntersection(bobsTasks,annsTasks);
        System.out.println("bob - ann: " + intersectionBobAnn);
        System.out.println("----------------- BOB - CAROL --------------------");
        Set<Task> intersectionBobCarol = taskData.getIntersection(bobsTasks, carolsTasks);
        System.out.println("bob -carol: " + intersectionBobCarol);
        System.out.println("----------------- ANN - CAROL --------------------");
        Set<Task> intersectionAnnCarol = taskData.getIntersection(annsTasks, carolsTasks);
        System.out.println("carol - ann: " + intersectionAnnCarol);


    }
}