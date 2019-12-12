package com.santiagoperdomo.arquitecturamvp

import com.santiagoperdomo.arquitecturamvp.login.LoginMVP
import com.santiagoperdomo.arquitecturamvp.login.LoginPresenter
import com.santiagoperdomo.arquitecturamvp.login.User
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class PresenterUnitTest {

    private lateinit var presenter: LoginPresenter
    lateinit var user: User

    private lateinit var mockedModel: LoginMVP.Model
    private lateinit var mockedView: LoginMVP.View

    @Before
    fun initialization(){

        mockedModel = mock(LoginMVP.Model::class.java)
        mockedView = mock(LoginMVP.View::class.java)

        presenter = LoginPresenter(mockedModel)
        user = User("Santiago", "Perdomo")

        presenter.setView(mockedView)
    }

    @Test
    fun callOneSetFirstName(){
        `when`(mockedModel.getUser()).thenReturn(user)
        presenter.getCurrentUser()
        verify(mockedView, times(1)).setFirstName(user.firstName)
    }

    @Test
    fun callNeverShowUserNotAvailable(){
        `when`(mockedModel.getUser()).thenReturn(user)
        presenter.getCurrentUser()
        verify(mockedView, never()).showUserNotAvailable()
    }

    @Test
    fun loadUserFromTheRepoWhenIsValid(){
        `when`(mockedModel.getUser()).thenReturn(user)
        presenter.getCurrentUser()

        verify(mockedView, times(1)).setFirstName("Santiago")
        verify(mockedView, times(1)).setLastName("Perdomo")
        verify(mockedView, never()).showUserNotAvailable()
    }

    @Test
    fun showErrorMessageUserNotAvailable(){
        presenter.getCurrentUser()
        verify(mockedModel, times(1)).getUser()
        verify(mockedView, never()).setFirstName("Santiago")
        verify(mockedView, never()).setLastName("Perdomo")
        verify(mockedView, times(1)).showUserNotAvailable()
    }

    @Test
    fun disabledIfAnyFieldIsEmpty(){
        `when`(mockedView.getFirstName()).thenReturn("")
        presenter.editTextChanged()
        verify(mockedView, times(1)).getFirstName()
        verify(mockedView, never()).getLastName()
        verify(mockedView, times(1)).enabledButtonLogin(false)

        `when`(mockedView.getFirstName()).thenReturn("Santiago")
        `when`(mockedView.getLastName()).thenReturn("")

        presenter.editTextChanged()
        verify(mockedView, times(2)).getFirstName()
        verify(mockedView, times(1)).getLastName()
        verify(mockedView, times(2)).enabledButtonLogin(false)
    }

    @Test
    fun enabledIfAnyFieldIsEmpty(){
        `when`(mockedView.getFirstName()).thenReturn("Santiago")
        `when`(mockedView.getLastName()).thenReturn("Perdomo")
        presenter.editTextChanged()
        verify(mockedView, times(1)).getFirstName()
        verify(mockedView, times(1)).getLastName()
        verify(mockedView, times(1)).enabledButtonLogin(true)
    }

    @Test
    fun savedUserValid(){
        `when`(mockedView.getFirstName()).thenReturn("Santiago")
        `when`(mockedView.getLastName()).thenReturn("Perdomo")

        presenter.editTextChanged()

        verify(mockedView, times(1)).getFirstName()
        verify(mockedView, times(1)).getLastName()
        verify(mockedView, times(1)).enabledButtonLogin(true)

        presenter.loginButtonClicked()

        verify(mockedView, times(2)).getFirstName()
        verify(mockedView, times(2)).getLastName()
        verify(mockedModel, times(1)).createUser("Santiago", "Perdomo")
        verify(mockedView, times(1)).showUserSaved()
    }

    /*@Test
    fun NotExistIteractionWithView(){
        presenter.getCurrentUser()
        verifyZeroInteractions(mockedView)
    }*/
}