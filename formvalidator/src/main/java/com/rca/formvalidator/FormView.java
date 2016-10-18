package com.rca.formvalidator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rca.formvalidator.interfaces.FormViewInterface;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public class FormView extends LinearLayout implements FormViewInterface {

    private boolean errorMode;
    private String errorMessage;
    private int marginTop;
    private int marginRight;
    private int marginBottom;
    private int marginLeft;

    // Views
    private TextView tvError;
    private EditText editText;

    public FormView(Context context, AttributeSet attrs) {

        super(context, attrs);
        init(attrs, 0);
    }

    public FormView(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);

    }

    @Override
    public void setError(String error) {

        errorMode = true;
        errorMessage = error;
        addError(error);
    }

    @Override
    public void closeError() {

        removeError();
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {

        if (child instanceof EditText) {

            setEditText((EditText) child);
            super.addView(child, 0, params);

        } else {

            super.addView(child, index, params);
        }
    }

    @Override
    protected Parcelable onSaveInstanceState() {

        Parcelable parcelable = super.onSaveInstanceState();
        SavedState savedState = new SavedState(parcelable);
        savedState.errorMessage = errorMessage;
        savedState.errorMode = errorMode;

        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {

        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());

        errorMessage = savedState.getErrorMessage();
        errorMode = savedState.isErrorMode();

        if (errorMode) {

            setError(errorMessage);
        }
    }

    static class SavedState extends View.BaseSavedState {

        boolean errorMode;
        String errorMessage;

        private SavedState(Parcel in) {

            super(in);
            errorMessage = in.readString();
            errorMode = in.readByte() != 0;
        }

        public SavedState(Parcelable superState) {

            super(superState);
        }

        public boolean isErrorMode() {
            return errorMode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        @Override
        public void writeToParcel(Parcel destination, int flags) {

            super.writeToParcel(destination, flags);
            destination.writeString(errorMessage);
            destination.writeByte((byte) (errorMode ? 1 : 0));
        }

        public static final Parcelable.Creator<SavedState> CREATOR = new Creator<SavedState>() {

            public SavedState createFromParcel(Parcel in) {

                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {

                return new SavedState[size];
            }
        };
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================

    private void init(AttributeSet attrs, int defStyle) {

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.FormView, defStyle, 0);
        marginTop = (int) a.getDimension(R.styleable.FormView_error_marginTop, 0);
        marginRight = (int) a.getDimension(R.styleable.FormView_error_marginRight, 0);
        marginBottom = (int) a.getDimension(R.styleable.FormView_error_marginBottom, 0);
        marginLeft = (int) a.getDimension(R.styleable.FormView_error_marginLeft, 0);

        setOrientation(VERTICAL);
        tvError = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.tv_error, null, false);
    }

    private void addError(String errorMessage) {

        removeView(tvError);
        tvError.setText(errorMessage);
        addView(tvError, getLayoutParamsErrorView());

        Drawable editTextBackground = getBackgroundDrawable();

        if (editTextBackground != null) {

            editTextBackground.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(
                    tvError.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        }
    }

    private void removeError() {

        errorMode = false;
        errorMessage = null;
        clearColorFilter(getBackgroundDrawable());
        removeView(tvError);

        if (editText != null) {

            editText.refreshDrawableState();
        }
    }

    private void setEditText(EditText editText) {

        this.editText = editText;

        if (tvError != null) {

            ViewCompat.setPaddingRelative(tvError, ViewCompat.getPaddingStart(editText), 0,
                    ViewCompat.getPaddingEnd(editText), editText.getPaddingBottom());
        }
    }

    private static void clearColorFilter(@NonNull Drawable drawable) {

        if (drawable == null) {

            return;
        }

        drawable.clearColorFilter();
        drawable.invalidateSelf();
    }

    private Drawable getBackgroundDrawable() {

        if (editText != null) {

            Drawable editTextBackground = editText.getBackground();

            if (editTextBackground != null && android.support.v7.widget.DrawableUtils.canSafelyMutateDrawable(editTextBackground)) {

                return editTextBackground.mutate();
            }
        }

        return null;
    }

    private LinearLayout.LayoutParams getLayoutParamsErrorView() {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginLeft, marginTop, marginRight, marginBottom);

        return layoutParams;
    }
}
