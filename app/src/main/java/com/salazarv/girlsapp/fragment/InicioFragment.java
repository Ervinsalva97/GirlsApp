package com.salazarv.girlsapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.google.firebase.firestore.FirebaseFirestore;
import com.salazarv.girlsapp.R;


public class InicioFragment extends Fragment {

    private ImageSlider carrusel;

    FirebaseFirestore firestore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);

    }
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        firestore = FirebaseFirestore.getInstance();
//
//        carrusel = carrusel.findViewById(R.id.textView);
//
//        ArrayList<SlideModel> slideModels =  new ArrayList<>();
//
//        firestore.collection("Sliders").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if (task.isSuccessful()){
//                    for (QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()){
//                        slideModels.add(new SlideModel(queryDocumentSnapshot.getString("URL"), ScaleTypes.FIT));
//                        carrusel.setImageList(slideModels, ScaleTypes.FIT);
//                    }
//                }else {
//                    Toast.makeText(getActivity(),"No se ha podido encontrar la tarea",Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(getActivity(), "No se ha encontrado imágenes", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }


}