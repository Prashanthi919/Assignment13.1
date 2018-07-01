package com.example.prashu.assignment131;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

/**
 * Created by Prashu on 01-07-2018.
 */

public class SimpleWidget extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        //update multiple widgets which are active
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    private void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.homescreen_widget);

        // Create an Intent object including the website address
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://acadgild.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        //handling the click event of the TextView by launching the website
        views.setOnClickPendingIntent(R.id.txtWidget, pendingIntent);
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

}
