package com.journeyai.glimpse.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.journeyai.glimpse.LocalNavigatorProvider
import com.journeyai.glimpse.ui.theme.primaryTextColor
import java.text.SimpleDateFormat
import java.util.Calendar

@Composable
fun Destination() {
    val navController = LocalNavigatorProvider.current
    var destinationText by rememberSaveable {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            "Enter your travel destination",
            style = TextStyle(
                fontSize = 22.sp,
                color = primaryTextColor,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(top = 24.dp)
        )
        TextField(
            modifier = Modifier
              .fillMaxWidth()
              .padding(top = 16.dp),
            value = destinationText,
            onValueChange = {
                destinationText = it
            },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
            ),
            placeholder = { Text("Travel destination") },
        )
        Text(
            "The days you are staying",
            style = TextStyle(
                fontSize = 22.sp,
                color = primaryTextColor,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(top = 40.dp)
        )

        val dateFormatter = remember {
            SimpleDateFormat("MM/dd/YY")
        }
        var startPickerShown = remember { mutableStateOf(false) }
        var endPickerShown = remember { mutableStateOf(false) }
        val startDatePickerState = rememberDatePickerState()
        val endDatePickerState = rememberDatePickerState()

        // Initializing a Calendar
        val mCalendar = Calendar.getInstance()


        // Start Picker Dialog
        if (startPickerShown.value) {
            DatePickerDialog(
                onDismissRequest = {
                    startPickerShown.value = false
                },
                confirmButton = {
                        Button(
                            onClick = {
                                startPickerShown.value = false
                            },
                        ) {
                            Text("Dismiss")
                        }
                },
            ) {
                DatePicker(
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(top = 16.dp),
                    state = startDatePickerState,
                    title = {
                        Text(
                            "Start Date",
                            modifier = Modifier
                                .padding(start = 16.dp),
                        )
                    },
                    headline = {}
                )

            }
        }

        // EndPicker Dialog
        if (endPickerShown.value) {
            DatePickerDialog(
                onDismissRequest = {
                    endPickerShown.value = false
                },
                confirmButton = {
                        Button(
                            shape = RoundedCornerShape(6.dp),
                            onClick = {
                                endPickerShown.value = false
                            },
                        ) {
                            Text("Dismiss")
                        }
                },
            ) {
                DatePicker(
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(top = 16.dp),
                    state = endDatePickerState,
                    title = {
                        Text(
                            "End Date",
                            modifier = Modifier
                                .padding(start = 16.dp),
                        )
                    },
                    headline = {}
                )

            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RectangleShape,
                modifier = Modifier
                  .padding(top = 24.dp),
                onClick = {
                    startPickerShown.value = true
                },
            ) {
                var startDate = "Start Date"
                startDatePickerState.selectedDateMillis?.let {
                    mCalendar.timeInMillis = it
                    startDate = dateFormatter.format(mCalendar.time)
                }
                Text(startDate)
            }
//      Spacer(modifier = Modifier.width(16.dp))
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RectangleShape,
                modifier = Modifier
                  .padding(top = 24.dp),
                onClick = {
                    endPickerShown.value = true
                },
            ) {
                var endDate = "End Date"
                endDatePickerState.selectedDateMillis?.let {
                    mCalendar.timeInMillis = it
                    endDate = dateFormatter.format(mCalendar.time)
                }
                Text(endDate)
            }
        }
        Spacer(modifier = Modifier.weight(0.6f))
        Button(
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
              .align(Alignment.End)
              .padding(end = 16.dp),
            onClick = {
                navController.navigate("grantAccess")
            },
        ) {
            Text("Next")
        }

    }
}