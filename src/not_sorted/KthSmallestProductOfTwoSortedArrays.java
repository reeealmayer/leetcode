package not_sorted;

public class KthSmallestProductOfTwoSortedArrays {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        // Гарантируем, что nums1 будет короче (для скорости)
        if (nums1.length > nums2.length) {
            return kthSmallestProduct(nums2, nums1, k);
        }

        long left = -1_000_000_000L * 1_000_000_000L;
        long right = 1_000_000_000L * 1_000_000_000L;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (countLessOrEqual(nums1, nums2, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Считает количество произведений <= x
    private long countLessOrEqual(int[] nums1, int[] nums2, long x) {
        long count = 0;
        for (int a : nums1) {
            if (a > 0) {
                // ищем максимальный j, такой что a * nums2[j] <= x
                int l = 0, r = nums2.length;
                while (l < r) {
                    int m = (l + r) / 2;
                    if ((long) a * nums2[m] <= x) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                count += l;
            } else if (a < 0) {
                // ищем минимальный j, такой что a * nums2[j] <= x
                int l = 0, r = nums2.length;
                while (l < r) {
                    int m = (l + r) / 2;
                    if ((long) a * nums2[m] <= x) {
                        r = m;
                    } else {
                        l = m + 1;
                    }
                }
                count += nums2.length - l;
            } else { // a == 0
                if (x >= 0) {
                    count += nums2.length;
                }
            }
        }
        return count;
    }}
