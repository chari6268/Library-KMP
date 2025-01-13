package org.chari6268.demo_app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.chari6268.demo_app.domain.Book

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(book: Book)

    @Update
    suspend fun updateBook(book: Book)

    @Transaction
    @Query("SELECT * FROM book WHERE _id = :bookId")
    suspend fun getBookById(bookId: Int): Book

    @Transaction
    @Query("SELECT * FROM book WHERE _id = :bookId")
    fun getBookByIdFlow(bookId: Int): Flow<Book?>

    @Transaction
    @Query("SELECT * FROM book ORDER BY isFavorite DESC")
    fun readAllBooksSortByFavorite(): Flow<List<Book>>

    @Transaction
    @Query("SELECT * FROM book")
    fun readAllBooks(): Flow<List<Book>>

    @Query("UPDATE book SET isFavorite = :isFavorite WHERE _id = :bookId")
    suspend fun setFavoriteBook(isFavorite: Boolean, bookId: Int)

    @Transaction
    @Query("DELETE FROM book WHERE _id = :bookId")
    suspend fun deleteBookById(bookId: Int)
}