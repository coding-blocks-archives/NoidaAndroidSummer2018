package com.codingblocks.widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.TextView;

import java.util.Random;

import static android.appwidget.AppWidgetManager.EXTRA_APPWIDGET_IDS;

/**
 * Implementation of App Widget functionality.
 */
public class MyWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them

        //int[] appWidgetIds contains the ID for all the widgets that are currently active

        for (int appWidgetId : appWidgetIds) {

            Integer random = new Random().nextInt(1000);

            RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.my_widget);
            remoteView.setTextViewText(R.id.appwidget_text, random.toString());

            Intent intent = new Intent();
            intent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
            //Pass the IDs of the current widget to the onUpdate method
            intent.putExtra(EXTRA_APPWIDGET_IDS, appWidgetIds);

            PendingIntent pi = PendingIntent.getBroadcast(context, 420, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            remoteView.setOnClickPendingIntent(R.id.parent, pi);

            //Notify the widget to be updated
            appWidgetManager.updateAppWidget(appWidgetId, remoteView);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

