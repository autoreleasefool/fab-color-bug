# fab-color-bug
Demonstrates a bug in the Android Design Support Library with the FloatingActionButton when used with API 22. Setting the color of a `FloatingActionButton` with multiple `FloatingActionButton` views on the screen causes all instances to be displayed with the same color. This effect can also be seen by changing the color in the on click of *one* of the `FloatingActionButton`, then tapping a different button, which causes it to become the same color as the other, without calling any of the same code.

The issue has been reported to the Android issue tracker [here](https://code.google.com/p/android/issues/detail?id=181440).

To reproduce:

1. Create a blank Android application.
2. Add `compile 'com.android.support:design:22.2.1'` to the dependencies.
3. Declare 2 or more `FloatingActionButton` views in the `activity_main.xml` as follows:

```
<RelativeLayout
	xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:paddingBottom="@dimen/activity_vertical_margin">

    <android.support.design.widget.FloatingActionButton
        android:id="@+id/fab_2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_margin="16dp"
        app:borderWidth="0dp"
        app:elevation="4dp"
        app:fabSize="normal" />

    <android.support.design.widget.FloatingActionButton
        android:id="@+id/fab_1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="16dp"
        android:layout_toLeftOf="@id/fab_2"
        app:borderWidth="0dp"
        app:elevation="4dp"
        app:fabSize="normal" />

    <android.support.design.widget.FloatingActionButton
        android:id="@+id/fab_3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="16dp"
        android:layout_toRightOf="@id/fab_2"
        app:borderWidth="0dp"
        app:elevation="4dp"
        app:fabSize="normal" />

</RelativeLayout>

```

4. In `MainActivity.java`, set the colors of all 3 `FloatingActionButton` views  to different colors by using the method:

```
fab.setBackgroundTintList(colorStateList);
```

5. Run the application, and all `FloatingActionButton` objects will have the same colors.

Screenshots
-----------

The following screenshots show the bug in action. First, API 22 where the bug occurs, then API 21 and API 19 where the bug has not yet been introduced.

![API 22 Screenshot](api22.png?raw=true)

![API 21 Screenshot](api21.png?raw=true)

![API 19 Screenshot](api19.png?raw=true)
