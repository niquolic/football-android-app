package com.nextu.nextu_android_advanced.ui.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.nextu.nextu_android_advanced.R
import com.nextu.nextu_android_advanced.ui.component.LoadingContent
import com.nextu.nextu_android_advanced.ui.extension.OnStartEffect

@Composable
fun TeamDetailScreen(
    viewModel: TeamDetailViewModel,
    modifier: Modifier = Modifier,
    id: String,
    onBackPressed: () -> Boolean
) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current

    OnStartEffect(lifecycleOwner) {
        viewModel.loadTeam(id)
    }

    Column (
        Modifier.fillMaxSize()
    ) {
        if (state.isLoading) {
            LoadingContent()
        } else {
            Column (
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Row {
                    IconButton(onClick = { onBackPressed() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Back Arrow"
                        )
                    }
                }
                Column (
                    Modifier
                        .verticalScroll(rememberScrollState(), enabled = true)
                        .weight(1f)
                ) {
                    AsyncImage(
                        model = state.team?.get(0)?.teamInfo?.logo,
                        contentDescription = "Image of the team ${state.team?.get(0)?.teamInfo?.name}",
                        placeholder = painterResource(id = R.drawable.ic_coffee),
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .height(300.dp)
                            .width(180.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    Column(
                        Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(10.dp)
                    ) {
                        state.team?.get(0)?.teamInfo?.name?.let { name ->
                            Text(name, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                        }
                        state.team?.get(0)?.teamInfo?.founded?.let { founded ->
                            Text("Fondé en "+founded.toString())
                        }
                    }
                    Column (
                        Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                    ){
                        state.team?.get(0)?.venueInfo?.name.let {
                            Text("Stade : "+it.toString(), fontSize = 20.sp)
                        }
                        state.team?.get(0)?.venueInfo?.capacity.let {
                            Text("Capacité : "+it.toString(), fontSize = 20.sp)
                        }
                    }
                    AsyncImage(
                        model = state.team?.get(0)?.venueInfo?.image,
                        contentDescription = "Image of the team ${state.team?.get(0)?.venueInfo?.image}",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .height(450.dp)
                            .width(400.dp)
                            .align(Alignment.CenterHorizontally)
                            .padding(bottom = 200.dp)
                    )
                }
            }
        }
    }
}