package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAsc() {
        Job item1 = new Job("Fix bug", 1);
        Job item2 = new Job("X task", 0);
        Job item3 = new Job("Fix bug", 4);
        Job item4 = new Job("Fix bug", 2);
        List<Job> jobs = Arrays.asList(
                item1,
                item2,
                item3,
                item4
        );
        Collections.sort(jobs, new JobAscByName());
        assertThat(jobs).containsExactly(
                item1,
                item3,
                item4,
                item2
        );
    }

    @Test
    public void whenComparatorByNameDesc() {
        Job item1 = new Job("Fix bug", 1);
        Job item2 = new Job("X task", 0);
        Job item3 = new Job("Fix bug", 4);
        Job item4 = new Job("Fix bug", 2);
        List<Job> jobs = Arrays.asList(
                item1,
                item2,
                item3,
                item4
        );
        Collections.sort(jobs, new JobDescByName());
        assertThat(jobs).containsExactly(
                item2,
                item1,
                item3,
                item4
        );
    }

    @Test
    public void whenComparatorByPriorityAsc() {
        Job item1 = new Job("Fix bug", 1);
        Job item2 = new Job("X task", 0);
        Job item3 = new Job("Fix bug", 4);
        Job item4 = new Job("Fix bug", 2);
        List<Job> jobs = Arrays.asList(
                item1,
                item2,
                item3,
                item4
        );
        Collections.sort(jobs, new JobAscByPriority());
        assertThat(jobs).containsExactly(
                item2,
                item1,
                item4,
                item3
        );
    }

    @Test
    public void whenNamesEqualsComparatorByNameAscAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenName1LessComparatorByNameAscAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl ", 0),
                new Job("Impl task123", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenName1GreaterComparatorByNameAscAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task123", 0),
                new Job("Impl ", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenNamesAndPrioritiesEqualsComparatorByNameAscAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    public void whenNamesEqualsComparatorByNameAscAndPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenName1LessComparatorByNameAscAndPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl ", 0),
                new Job("Impl task123", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenName1GreaterComparatorByNameAscAndPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task123", 0),
                new Job("Impl ", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenNamesAndPrioritiesEqualsComparatorByNameAscAndPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    public void whenNamesEqualsComparatorByNameDescAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenName1LessComparatorByNameDescAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl ", 0),
                new Job("Impl task123", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenName1GreaterComparatorByNameDescAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task123", 0),
                new Job("Impl ", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenNamesAndPrioritiesEqualsComparatorByNameDescAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isEqualTo(0);
    }
}