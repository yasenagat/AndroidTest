package com.y;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zf on 2015/5/12.
 */
@Module(injects = MainActivity.class)
public class AppModule {
    @Provides
    Coder provideCoder() {
        return new Coder();
    }
}
