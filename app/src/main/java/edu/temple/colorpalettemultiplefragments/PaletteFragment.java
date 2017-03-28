package edu.temple.colorpalettemultiplefragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;



public class PaletteFragment extends Fragment {

    Context context;
    PaletteInterface activity;


    //    View choicesView;
        String[] myColors = {"No selection", "Red", "Blue", "Grey", "Yellow", "Cyan", "Black", "LightGray", "Green", "Magenta", "DarkGray"};

    private PaletteInterface mListener;

    public PaletteFragment() {
        // Required empty public constructor
    }

    public PaletteFragment(Context c) {
        this.context = c;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View choicesView = inflater.inflate(R.layout.fragment_palette, container, false);

        GridView gv = (GridView) choicesView.findViewById(R.id.gridview);
        final ColorAdapter colorAdapter = new ColorAdapter(context, myColors);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            activity.getColor(colorAdapter.getItem(i).toString());
            }
        });

        gv.setAdapter(colorAdapter);




        return choicesView;
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PaletteInterface) {
            mListener = (PaletteInterface) context;
            activity = (PaletteInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface PaletteInterface {
        // TODO: Update argument type and name
        void getColor(String color);
    }
}
