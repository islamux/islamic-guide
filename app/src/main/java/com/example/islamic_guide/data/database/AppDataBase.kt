import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import android.content.Context
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.RoomDatabase.Callback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities=[Daee::class],version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun daeeDao() : DaeeDao
    companion object{
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
                return instance ?: synchronized(this) {
                    Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database"
                    )
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            CoroutineScope(Dispatchers.IO).launch {
                                getInstance(context).daeeDao().insertAllDaee(mockData())
                            }
                        }
                    })
                    .build().also { instance = it }
                }
            }

                            fun getInstance(context: Context): AppDatabase {
                                return instance ?: synchronized(this) {
                                    instance ?: Room.databaseBuilder(
                                        context.applicationContext,
                                        AppDatabase::class.java,
                                        "app_database"
                                    ).build().also { instance = it }
                                }
                            }

                        // بيانات عشوائية
                        private fun mockData(): List<Daee> {
                            return listOf(
                                Daee(
                                    id = 1,
                                    name = "أحمد ديدات",
                                    description = "داعية إسلامي متخصص في مقارنة الأديان، مؤسس IPCI.",
                                    youtubeLink = "https://youtube.com/ahmaddeedat",
                                    // facebook = "https://facebook.com/ahmaddeedat",
                                    // twitter = "https://twitter.com/ahmaddeedat",
                                    // whatsapp = "+123456789"
                                ),
                                Daee(
                                    id = 2,
                                    name = "ذاكر نايك",
                                    description = "داعية هندي، متخصص في مقارنة الأديان والإعجاز العلمي.",
                                    youtubeLink = "https://youtube.com/zakirnaik",
                                    // facebook = "https://facebook.com/zakirnaik",
                                    // twitter = "https://twitter.com/zakirnaik",
                                    // whatsapp = "+987654321"
                                ),
                                Daee(
                                    id = 3,
                                    name = "يوسف إستس",
                                    description = "قسيس أمريكي اعتنق الإسلام وأصبح داعية عالميًا.",
                                    youtubeLink = "https://youtube.com/yusufestes",
                                    // facebook = "https://facebook.com/yusufestes",
                                    // twitter = "https://twitter.com/yusufestes",
                                    // whatsapp = "+1122334455"
                                )
                            )
                        }
                            }
                        }
                    
    

