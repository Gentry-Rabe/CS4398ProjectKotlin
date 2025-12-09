package com.example.fixcsproject.laundryapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.example.fixcsproject.laundryapp.model.Employee
import com.example.fixcsproject.laundryapp.model.Job
import com.example.fixcsproject.laundryapp.model.JobStatus
import com.example.fixcsproject.laundryapp.model.PaymentInfo
import com.example.fixcsproject.laundryapp.model.UserAccount
import com.example.fixcsproject.laundryapp.service.PaymentSystem
import com.example.fixcsproject.ui.login.UserDatabase
import com.laundryapp.service.RatingSystem

class LaundryAppMain : ComponentActivity() {
    //System.out.println("Reaching 36");
    // === System Entities ===
    private var employees: MutableList<Employee> = mutableListOf()
    private var jobs: MutableList<Job> = mutableListOf()
    private lateinit var paymentSystem: PaymentSystem
    private lateinit var ratingSystem: RatingSystem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeData()

        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                //System.out.println("Reaching 52");
                CSProjectPortApp()
            }
        }
    }

    // === Initialization ===
    private fun initializeData() {
        paymentSystem = PaymentSystem()
        ratingSystem = RatingSystem()

        // Create placeholder users and employees
        val user1 = UserAccount("JohnDoe", "John Doe", "john@example.com", "pass123", "Austin, TX", null, null)
        val emp1 = Employee(101, "Jane Smith", "jane@example.com", "securePass")

        val userPayInfo = PaymentInfo("123456", "Bank of Texas", "111000025", 500.00)
        user1.paymentInfo = userPayInfo

        val empPayInfo = PaymentInfo("654321", "Chase", "222000077", 0.00)
        emp1.payAccount = empPayInfo

        UserDatabase.getInstance().addUser(user1)
        employees.add(emp1)
    }

    // === Core System Functionalities (method definitions only) ===

    // User-related methods
    fun registerUser(user: UserAccount) {
    }

    fun updateUser(user: UserAccount) {
    }

    fun deleteUser(user: UserAccount) {
    }

    // com.example.fixcsproject.laundryapp.model.Employee-related methods
    fun registerEmployee(employee: Employee) {
    }

    fun updateEmployee(employee: Employee) {
    }

    fun deleteEmployee(employee: Employee) {
    }

    // com.example.fixcsproject.laundryapp.model.Job-related methods
    fun createJob(job: Job) {
    }

    fun assignJob(employee: Employee, job: Job) {
    }

    fun updateJobStatus(job: Job, status: JobStatus) {
    }

    fun completeJob(job: Job) {
    }

    // Payment-related methods
    fun processPayment(user: UserAccount, employee: Employee, amount: Double) {
    }

    fun refundPayment(user: UserAccount, amount: Double) {
    }

    // Rating-related methods
    fun rateUser(user: UserAccount, rating: Double) {
    }

    fun rateEmployee(employee: Employee, rating: Double) {
    }

    // === Utility Methods ===
    fun listUsers() {
    }

    fun listEmployees() {
    }

    fun listJobs() {
    }
}

@PreviewScreenSizes
@Composable
fun CSProjectPortApp() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            it.icon,
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Greeting(
                name = "Android",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    HOME("Home", Icons.Default.Home),
    FAVORITES("Favorites", Icons.Default.Favorite),
    PROFILE("Profile", Icons.Default.AccountBox)
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialTheme {
        Greeting("Android")
    }
}
