package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class ViewBoundsCheck {
    static final int CVE_PVE_POS = 12;
    static final int CVE_PVS_POS = 8;
    static final int CVS_PVE_POS = 4;
    static final int CVS_PVS_POS = 0;
    static final int EQ = 2;
    static final int FLAG_CVE_EQ_PVE = 8192;
    static final int FLAG_CVE_EQ_PVS = 512;
    static final int FLAG_CVE_GT_PVE = 4096;
    static final int FLAG_CVE_GT_PVS = 256;
    static final int FLAG_CVE_LT_PVE = 16384;
    static final int FLAG_CVE_LT_PVS = 1024;
    static final int FLAG_CVS_EQ_PVE = 32;
    static final int FLAG_CVS_EQ_PVS = 2;
    static final int FLAG_CVS_GT_PVE = 16;
    static final int FLAG_CVS_GT_PVS = 1;
    static final int FLAG_CVS_LT_PVE = 64;
    static final int FLAG_CVS_LT_PVS = 4;
    static final int GT = 1;
    static final int LT = 4;
    static final int MASK = 7;
    BoundFlags mBoundFlags;
    final Callback mCallback;

    interface Callback {
        View getChildAt(int i);

        int getChildCount();

        int getChildEnd(View view);

        int getChildStart(View view);

        View getParent();

        int getParentEnd();

        int getParentStart();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewBounds {
    }

    ViewBoundsCheck(Callback callback) {
        BoundFlags boundFlags;
        this.mCallback = callback;
        new BoundFlags();
        this.mBoundFlags = boundFlags;
    }

    static class BoundFlags {
        int mBoundFlags = 0;
        int mChildEnd;
        int mChildStart;
        int mRvEnd;
        int mRvStart;

        BoundFlags() {
        }

        /* access modifiers changed from: package-private */
        public void setBounds(int rvStart, int rvEnd, int childStart, int childEnd) {
            this.mRvStart = rvStart;
            this.mRvEnd = rvEnd;
            this.mChildStart = childStart;
            this.mChildEnd = childEnd;
        }

        /* access modifiers changed from: package-private */
        public void setFlags(int flags, int i) {
            int mask = i;
            this.mBoundFlags = (this.mBoundFlags & (mask ^ -1)) | (flags & mask);
        }

        /* access modifiers changed from: package-private */
        public void addFlags(int flags) {
            this.mBoundFlags |= flags;
        }

        /* access modifiers changed from: package-private */
        public void resetFlags() {
            this.mBoundFlags = 0;
        }

        /* access modifiers changed from: package-private */
        public int compare(int i, int i2) {
            int x = i;
            int y = i2;
            if (x > y) {
                return 1;
            }
            if (x == y) {
                return 2;
            }
            return 4;
        }

        /* access modifiers changed from: package-private */
        public boolean boundsMatch() {
            if ((this.mBoundFlags & 7) != 0 && (this.mBoundFlags & (compare(this.mChildStart, this.mRvStart) << 0)) == 0) {
                return false;
            }
            if ((this.mBoundFlags & 112) != 0 && (this.mBoundFlags & (compare(this.mChildStart, this.mRvEnd) << 4)) == 0) {
                return false;
            }
            if ((this.mBoundFlags & 1792) != 0 && (this.mBoundFlags & (compare(this.mChildEnd, this.mRvStart) << 8)) == 0) {
                return false;
            }
            if ((this.mBoundFlags & 28672) == 0 || (this.mBoundFlags & (compare(this.mChildEnd, this.mRvEnd) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public View findOneViewWithinBoundFlags(int i, int i2, int i3, int i4) {
        int fromIndex = i;
        int toIndex = i2;
        int preferredBoundFlags = i3;
        int acceptableBoundFlags = i4;
        int start = this.mCallback.getParentStart();
        int end = this.mCallback.getParentEnd();
        int next = toIndex > fromIndex ? 1 : -1;
        View acceptableMatch = null;
        int i5 = fromIndex;
        while (true) {
            int i6 = i5;
            if (i6 == toIndex) {
                return acceptableMatch;
            }
            View child = this.mCallback.getChildAt(i6);
            this.mBoundFlags.setBounds(start, end, this.mCallback.getChildStart(child), this.mCallback.getChildEnd(child));
            if (preferredBoundFlags != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(preferredBoundFlags);
                if (this.mBoundFlags.boundsMatch()) {
                    return child;
                }
            }
            if (acceptableBoundFlags != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(acceptableBoundFlags);
                if (this.mBoundFlags.boundsMatch()) {
                    acceptableMatch = child;
                }
            }
            i5 = i6 + next;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isViewWithinBoundFlags(View view, int i) {
        View child = view;
        int boundsFlags = i;
        this.mBoundFlags.setBounds(this.mCallback.getParentStart(), this.mCallback.getParentEnd(), this.mCallback.getChildStart(child), this.mCallback.getChildEnd(child));
        if (boundsFlags == 0) {
            return false;
        }
        this.mBoundFlags.resetFlags();
        this.mBoundFlags.addFlags(boundsFlags);
        return this.mBoundFlags.boundsMatch();
    }
}