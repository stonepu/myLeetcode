package algrithm;

public class GetMedianFromBigDataTest {
    /**
     * create table VisitedInfo(
     * id bigint(20) not null auto_increment,
     * delay int(11) unsigned not null,
     * primary key(id),
     * index(delay)
     * )engine=InnoDB default charset=utf8;
     */
    class VisitedQuery {

        public Long getSize() {
            String query = "SELECT COUNT(*) FROM VisitedInfo;";
            return (Long) queryByString(query);
        }

        public int[] getRangeDelayByPage(int page, int numPerPage) {
            long position = (page - 1) * numPerPage;
            String query = "SELECT delay FROM VisitedInfo WHERE id > " + position + " limit " + numPerPage + ";";
            return (int[]) queryByString(query);
        }


        public Object queryByString(String query) {
            //TODO
            return null;
        }
    }

    static int numsPerPage = 10000000; //每次从数据库中拿出一千万条数据
    static int bucketNum = 100000;


    public static int getMedianRT(VisitedQuery visited) {
        long min = 0, max = 0;
        long size = visited.getSize();
        long currPosition = 0;
        int page = (int) ((size + numsPerPage - 1) / numsPerPage);

        long[] frequency = getFrequency(visited, page);

        for (int i = 0; i < bucketNum; i++) {
            if (currPosition + frequency[i] >= (size - 1) / 2) {
                min = i * Integer.MAX_VALUE / bucketNum;
                max = (i + 1) * Integer.MAX_VALUE / bucketNum - 1;
                break;
            }
        }

        long[] ithBucketFre = getBucketByPosition(visited, min, max, page);


        int ithIndex;
        for (ithIndex = 0; ithIndex < ithBucketFre.length; ithIndex++) {
            if (currPosition + ithBucketFre[ithIndex] >= size / 2) {
                break;
            }
        }

        if (size % 2 != 0 || currPosition + ithBucketFre[ithIndex] > size / 2) {
            return (int) min + ithIndex;
        }

        for (int i = ithIndex + 1; i < ithBucketFre.length; i++) {
            if (ithBucketFre[i] > 0) {
                return (int) min + (ithIndex + i) / 2;
            }
        }

        min += Integer.MAX_VALUE / bucketNum;
        max += Integer.MAX_VALUE / bucketNum;
        long[] nextBucketFre = getBucketByPosition(visited, min, max, page);
        for (int i = 0; i < nextBucketFre.length; i++) {
            if (nextBucketFre[i] > 0) {
                return (int) ((min * 2 - Integer.MAX_VALUE / bucketNum + ithIndex + i) / 2);
            }
        }
        return -1;
    }

    /**
     * 遍历数据，找到每一个桶中出现数字的频率
     *
     * @param visited
     * @param page
     * @return
     */
    public static long[] getFrequency(VisitedQuery visited, int page) {
        long[] frequency = new long[bucketNum];

        for (int i = 0; i < page; i++) {
            int[] getByPage = visited.getRangeDelayByPage(i, numsPerPage);
            for (int it : getByPage) {
                int index = it / (Integer.MAX_VALUE / bucketNum);
                frequency[index]++;
            }
        }
        return frequency;
    }

    /**
     * 遍历数据，找到其中位于min和max之间的所有数的频率
     *
     * @param visited
     * @param min
     * @param max
     * @param page
     * @return
     */
    public static long[] getBucketByPosition(VisitedQuery visited, long min, long max, int page) {
        int len = (int) (max - min + 1);
        long[] ithBucketFre = new long[len];

        for (int i = 0; i < page; i++) {
            int[] getByPage = visited.getRangeDelayByPage(i, numsPerPage);
            for (int it : getByPage) {
                if (it < min || it > max) continue;
                ithBucketFre[(int) (it - min)]++;
            }
        }

        return ithBucketFre;
    }
}
