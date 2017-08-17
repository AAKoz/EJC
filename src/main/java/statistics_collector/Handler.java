package statistics_collector;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Handler {
    /**
     * Information handling in list
     *
     * @param rawList unsorted list of strings
     */
    public void informationHandlingInList(List<String> rawList) {
        sortListAndUniteSameURL(rawList);
    }

    /**
     * Sorts list with strings, combines same url's for one user in one string and sums time
     *
     * @param rawList unsorted list of strings
     */
    private void sortListAndUniteSameURL(List<String> rawList) {
        Collections.sort(rawList);
        String assistantStringForFirstElement;
        String assistantStringForSecondElement;
        Long time;
        for (int i = 0; i < rawList.toArray().length - 1; i++) {
            assistantStringForFirstElement = rawList.get(i);
            assistantStringForSecondElement = rawList.get(i + 1);
            if (Objects.equals(assistantStringForFirstElement.substring(
                    assistantStringForFirstElement.indexOf(';') + 1,
                    assistantStringForFirstElement.lastIndexOf(';') + 1),
                    assistantStringForSecondElement.substring(
                            assistantStringForSecondElement.indexOf(';') + 1,
                            assistantStringForSecondElement.lastIndexOf(';') + 1)) &&
                    Objects.equals(assistantStringForFirstElement.substring(
                            0,
                            assistantStringForFirstElement.indexOf(';') + 1),
                            assistantStringForSecondElement.substring(
                                    0,
                                    assistantStringForSecondElement.indexOf(';') + 1))) {
                time = Long.parseLong(assistantStringForFirstElement.substring(
                        assistantStringForFirstElement.lastIndexOf(';') + 1)) +
                        Long.parseLong(assistantStringForSecondElement.substring(
                                assistantStringForSecondElement.lastIndexOf(';') + 1));
                assistantStringForFirstElement = assistantStringForFirstElement.substring(
                        0,
                        assistantStringForFirstElement.lastIndexOf(';') + 1) +
                        time;
                rawList.set(i, assistantStringForFirstElement);
                rawList.remove(i + 1);
            }
        }

        for (int i = 0; i < rawList.toArray().length; i++) {
            assistantStringForFirstElement = rawList.get(i);
            time = Long.parseLong(assistantStringForFirstElement.substring(
                    assistantStringForFirstElement.lastIndexOf(';') + 1));
            assistantStringForFirstElement = assistantStringForFirstElement.substring(
                    0,
                    assistantStringForFirstElement.lastIndexOf(';') + 1) +
                    setTimeInDaysHoursMinutesSeconds(time);
            rawList.set(i, assistantStringForFirstElement);
        }
    }

    /**
     * Sets time in days, hours, minutes, seconds, milliseconds
     *
     * @param time time in milliseconds
     * @return time in days, hours, minutes, seconds, milliseconds
     */
    private String setTimeInDaysHoursMinutesSeconds(Long time) {
        if (time < 1000) {
            return time + " ms";
        } else {
            if (time < 60000) {
                return (time / 1000) + " sec " + (time % 1000) + " ms";
            } else {
                if (time < 3600000) {
                    return time / 60000 + " min " + (time % 60000) / 1000 + " sec " + (time % 1000) + " ms";
                } else {
                    if (time < 86400000) {
                        return time / 3600000 + " hour " + (time % 3600000) / 60000 + " min " +
                                (time % 60000) / 1000 + " sec " + (time % 1000) + " ms";
                    } else {
                        return time / 86400000 + " day " + (time % 86400000) / 3600000 + " hour " +
                                (time % 3600000) / 60000 + " min " + (time % 60000) / 1000 + " sec " +
                                (time % 1000) + " ms";
                    }
                }
            }
        }
    }
}
