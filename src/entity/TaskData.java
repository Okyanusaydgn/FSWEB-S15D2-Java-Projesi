package entity;

// set ve list farklı koleksiyon türleridir.
// list : her elemanın bir indeksi vardır ve elemanları sırası bellidir.
// List elemanları sıralı tutar.
// List yapısında aynı eleman bir den fazla bulunabilir.
// set elemanların bir indeksi yoktur bundan dolayı bu elemanların bir sırası da yoktur.
// set yapısı içinde bir eleman bir den fazla bulunamaz, set içinde o eleman bir tanedir aynı elemanı göremessiniz.

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TaskData {

    private Set <Task> annsTasks;

    private Set<Task> bobsTasks;

    private Set<Task> carolsTasks;

    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set <Task> getTasks(String owner){

        return switch (owner) {
            case "ann" -> this.annsTasks;
            case "bob" -> this.bobsTasks;
            case "carol" -> this.carolsTasks;
            case "all" -> getUnion(bobsTasks, annsTasks, carolsTasks);
            default -> null;
        };

        /*
        switch (owner){
            case "ann":
                return this.annsTasks;
            case "bob":
                return this.bobsTasks;
            case "carol":
                return this.carolsTasks;
            case "all":
                return getUnion(bobsTasks,annsTasks,carolsTasks);
            default:
                return null;
        }

        if (owner.equalsIgnoreCase("ann")){
            return this.annsTasks;
        }
        if (owner.equalsIgnoreCase("bob")){
            return this.bobsTasks;
        }
        if (owner.equalsIgnoreCase("carol")){
            return this.carolsTasks;
        }
        if (owner.equalsIgnoreCase("all")){
            return getUnion(bobsTasks,annsTasks,carolsTasks);
        }
        return null;
         */
    }

    //HashSet<Task> total = new LinkedHashSet<>(); --> işlem sırasında toplam elemanları tutmak için bir "HashSet"kullanılıyor, ancak elemanların sırasının korunmasını istendiğinden "LinkedHashSet" yapısı kullanılıyor.
    public Set<Task> getUnion(Set<Task>...sets){
        HashSet<Task> total = new LinkedHashSet<>();
        for (Set<Task> set : sets){
            total.addAll(set);
        }
        return total;
    }

    public Set<Task> getIntersection(Set<Task> first, Set<Task> second){
        Set<Task> intersections = new LinkedHashSet<>(first);
        intersections.retainAll(second); // first ve second daki ortak olan yapıları alacak.
        return intersections;
    }

    // yukarıdaki metodun başka bir yolu

    /*public Set<Task> getIntersect(Set<Task> set1, Set<Task> set2){

        Set<Task> intersection = new HashSet<>();

        for (Task task : set1){

            if (set2.contains(task)){

                intersection.add(task);
            }
        }
        return intersection;
    }*/

    public Set<Task> getDifferences(Set<Task> first, Set<Task> second){
        Set<Task> differences = new HashSet<>(first);
        differences.removeAll(second); // 2. deki yapılardan 1. de var ise 1.den sil diyoruz yani kodun yazılış amacı bu.
        return differences;
    }

    /*
    public Set<Task> getIntersect(Set<Task> set1, Set<Task> set2){

        Set<Task> differences = new HashSet<>(set1);

        differences.removeAll(set2);

        return differences;
     */
}
