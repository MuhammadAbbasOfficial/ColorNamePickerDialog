package com.color.picker.colornamepicker;

import static com.color.picker.colornamepicker.util.Util.colorList;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.color.picker.colornamepicker.adapter.ColorAdapter;
import com.color.picker.colornamepicker.listener.GetColorFromPallet;
import com.color.picker.colornamepicker.model.ColorModel;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ColorNamePicker {

    public static void ColorNamePickerDailog(Activity context, GetColorFromPallet getColorFromPallet)
    {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayList<ColorModel> colorList= new ArrayList<>();
                        colorList.addAll(colorList());
                        Dialog dialog = new Dialog(context);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.setContentView(R.layout.color_pallet_dialoge);

                        final String[] color = {null};
                        final String[] hex = {""};

                        final ImageView iv_dialog_img = dialog.findViewById(R.id.iv_dialog_img);
                        final TextView colorName = dialog.findViewById(R.id.colorName);
                        final RecyclerView recyclerView = dialog.findViewById(R.id.rv_pallete);
                        final AppCompatButton submit = dialog.findViewById(R.id.tv_dialog_button);
                        final AppCompatButton cancel = dialog.findViewById(R.id.bt_cancel);
                        final RelativeLayout relative2 = dialog.findViewById(R.id.relative2);


                        final ImageView iv_dialog_close = dialog.findViewById(R.id.iv_dialog_close);


                        GridLayoutManager layoutManager = new GridLayoutManager(context, 4, LinearLayoutManager.HORIZONTAL, false);

                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setHasFixedSize(true);

                        //1030 color names with hex have been inserted
                        ColorAdapter colorAdapter = new ColorAdapter(colorList, context,
                                new ColorAdapter.ColorOnItemClickListener() {
                                    @Override
                                    public void coloronItemClick(String text, String hexV) {
                                            colorName.setText(text);
                                            color[0] = text;
                                            hex[0] = hexV;
                                    }
                                });

                        recyclerView.setAdapter(colorAdapter);


                        colorName.setText("Color Pallete");
                        iv_dialog_close.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });
                        cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });

//        WeakReference<GetColorFromPallet> callbackRef = new WeakReference<>(getColorFromPallet);

                        submit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (color[0] != null && !color[0].isEmpty()) { // Check if a color is selected
                                    dialog.dismiss();
                                    if (getColorFromPallet != null) {
                                        getColorFromPallet.getColor(color[0], hex[0]);
                                    }
                                } else {
                                    Toast.makeText(context, "Please Select Color.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        dialog.setCancelable(false);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                        //dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                        dialog.show();
                        Window window = dialog.getWindow();
                        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

                    }
                });
            }
        });
        executor.shutdown();
    }



}
