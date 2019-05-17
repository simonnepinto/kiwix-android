/*
 * Kiwix Android
 * Copyright (C) 2018  Kiwix <android.kiwix.org>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.kiwix.kiwixmobile.di.modules;

import android.app.Application;
import android.app.DownloadManager;
import android.app.NotificationManager;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;
import javax.inject.Singleton;
import org.kiwix.kiwixmobile.utils.BookUtils;

@Module(includes = {
    ActivityBindingModule.class,
    AndroidInjectionModule.class,
    DownloaderModule.class,
    ViewModelModule.class,
    DatabaseModule.class
})
public class ApplicationModule {

  @Provides @Singleton Application provideApplication(Context context) {
    return (Application) context;
  }

  @Provides @Singleton NotificationManager provideNotificationManager(Context context) {
    return (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
  }

  @Provides @Singleton DownloadManager provideDownloadManager(Context context) {
    return (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
  }

  @Provides @Singleton
  BookUtils provideBookUtils() {
    return new BookUtils();
  }
}
